/*
 * Copyright 2015 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.jbpm.designer.server.diagram;

/**
 * @author Philipp Bounded interface gets implement when spanning an area
 */
public interface Bounded {
    /**
     * @return Point Object of the upper left
     */
    public Point getUpperLeft();

    /**
     * @return Point Object of the lower right
     */
    public Point getLowerRight();

    /**
     * @return The width of the spanned area
     */
    public double getWidth();

    /**
     * @return The height of the spanned area
     */
    public double getHeight();
}
