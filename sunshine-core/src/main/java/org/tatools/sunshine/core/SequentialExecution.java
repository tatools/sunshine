package org.tatools.sunshine.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class encapsulates several {@link Kernel}s and runs them sequentially.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 */
public class SequentialExecution<Listener> implements Kernel<Listener> {

    private final List<Kernel<Listener>> elements;

    @SafeVarargs
    public SequentialExecution(Kernel<Listener>... kernels) {
        this(Arrays.asList(kernels));
    }

    public SequentialExecution(List<Kernel<Listener>> kernels) {
        this.elements = kernels;
    }

    @Override
    public Status status() throws KernelException {
        final List<Status> results = new ArrayList<>();
        for (Kernel<Listener> kernel : this.elements) {
            results.add(kernel.status());
        }
        return new CompositeStatus(results);
    }

    @Override
    public Kernel<Listener> with(Listener... listeners) {
        return new SequentialExecution<>(
                this.elements.stream()
                        .map(listenerKernel -> listenerKernel.with(listeners))
                        .collect(Collectors.toList())
        );
    }
}
