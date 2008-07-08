/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.math.ode;

import java.io.Serializable;
import java.util.Collection;

import org.apache.commons.math.ode.events.EventHandler;
import org.apache.commons.math.ode.sampling.StepHandler;

public interface ODEIntegrator extends Serializable {

    /** Get the name of the method.
     * @return name of the method
     */
    String getName();

    /** Add a step handler to this integrator.
     * <p>The handler will be called by the integrator for each accepted
     * step.</p>
     * @param handler handler for the accepted steps
     * @see #getStepHandlers()
     * @see #clearStepHandlers()
     * @since 2.0
     */
    void addStepHandler(StepHandler handler);

    /** Get all the step handlers that have been added to the integrator.
     * @return an unmodifiable collection of the added events handlers
     * @see #addStepHandler(StepHandler)
     * @see #clearStepHandlers()
     * @since 2.0
     */
    Collection<StepHandler> getStepHandlers();

    /** Remove all the step handlers that have been added to the integrator.
     * @see #addStepHandler(StepHandler)
     * @see #getStepHandlers()
     * @since 2.0
     */
    void clearStepHandlers();

    /** Add an event handler to the integrator.
     * @param handler event handler
     * @param maxCheckInterval maximal time interval between switching
     * function checks (this interval prevents missing sign changes in
     * case the integration steps becomes very large)
     * @param convergence convergence threshold in the event time search
     * @param maxIterationCount upper limit of the iteration count in
     * the event time search
     * @see #getEventHandlers()
     * @see #clearEventHandlers()
     */
    void addEventHandler(EventHandler handler,
                                         double maxCheckInterval,
                                         double convergence,
                                         int maxIterationCount);

    /** Get all the event handlers that have been added to the integrator.
     * @return an unmodifiable collection of the added events handlers
     * @see #addEventHandler(EventHandler, double, double, int)
     * @see #clearEventHandlers()
     */
    Collection<EventHandler> getEventHandlers();

    /** Remove all the event handlers that have been added to the integrator.
     * @see #addEventHandler(EventHandler, double, double, int)
     * @see #getEventHandlers()
     */
    void clearEventHandlers();

    /** Get the current value of the step start time t<sub>i</sub>.
     * <p>This method can be called during integration (typically by
     * the object implementing the {@link FirstOrderDifferentialEquations
     * differential equations} problem) if the value of the current step that
     * is attempted is needed.</p>
     * <p>The result is undefined if the method is called outside of
     * calls to {@link #integrate}</p>
     * @return current value of the step start time t<sub>i</sub>
     */
    double getCurrentStepStart();

    /** Get the current signed value of the integration stepsize.
     * <p>This method can be called during integration (typically by
     * the object implementing the {@link FirstOrderDifferentialEquations
     * differential equations} problem) if the signed value of the current stepsize
     * that is tried is needed.</p>
     * <p>The result is undefined if the method is called outside of
     * calls to {@link #integrate}</p>
     * @return current signed value of the stepsize
     */
    double getCurrentSignedStepsize();

}