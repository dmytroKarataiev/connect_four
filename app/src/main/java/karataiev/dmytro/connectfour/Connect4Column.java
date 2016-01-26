package karataiev.dmytro.connectfour;

/**
 * A single column in a Connect 4 game. A column stores a number of individual slots.
 */
public class Connect4Column
{
    private Connect4Slot[] slots;
    
    /**
     * Creates a new Connect4Column with a given height.
     *
     * @param height the height of the column.
     */
    public Connect4Column(int height)
    {
        slots = new Connect4Slot[height];
        for (int i = 0; i < height; i++)
        {
            slots[i] = new Connect4Slot();
        }
    }

    /**
     * Creates a copy of the given Connect4Column.
     *
     * @param column the column to copy.
     */
    public Connect4Column(Connect4Column column)
    {
        this.slots = new Connect4Slot[column.getRowCount()];
        for (int i = 0; i < column.getRowCount(); i++)
        {
            slots[i] = new Connect4Slot(column.getSlot(i));
        }
    }

    /**
     * Returns a single Connect4Slot from the column.
     *
     * @param i the Connect4Slot to retrieve.
     * @return the Connect4Slot at that index.
     */
    public Connect4Slot getSlot(int i)
    {
        if (i < slots.length && i >= 0)
        {
            return slots[i];
        }
        else
        {
            return null;
        }
    }

    /**
     * Checks if the column is full.
     *
     * @return true if the column is full, false otherwise.
     */
    public boolean getIsFull()
    {
        for (Connect4Slot slot : slots)
        {
            if (!slot.getIsFilled())
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the number of rows in the column.
     *
     * @return the number of rows in the column.
     */
    public int getRowCount()
    {
        return slots.length;
    }

    /**
     * Returns true if column is empty
     * 
     * @return boolean true if column is empty, false otherwise
     */
    public boolean isEmpty()
    {
    	boolean empty = true;
    	
    	for (Connect4Slot each : slots)
    	{
    		if (each.getIsFilled())
    		{
    			empty = false;
    		}
    	}
    	
    	return empty;
    }

    /**
     * Method to set false for each slot's isLastFilled variable,
     * so it won't be highlighted on draw
     */
    public void clearLastMove() {
        for (Connect4Slot slot : slots)
        {
            slot.setLastFilled();
        }
    }
}
