/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

/**
 * This class is responsible to define the basic recipe for game components.
 *
 * @author angelo
 */
public abstract class Component {

    protected GameObject gameObject;
    protected ComponentId id;

    public Component(GameObject gameObject, ComponentId id) {
        this.gameObject = gameObject;
        this.id = id;
    }

    /**
     * Create a copy of this component
     *
     * @param gameObject is the object that will have the copied component.
     * @return copied component.
     */
    public abstract Component createCopy(GameObject gameObject);

    /**
     * Update the state of this component.
     */
    public abstract void update();

    /**
     * Initialise the state of this component. Will be called first, in the
     * first frame.
     */
    public abstract void start();

    /**
     * Will be called on the last frame of this component.
     */
    public abstract void destroy();
}
