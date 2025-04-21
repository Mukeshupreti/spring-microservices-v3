package streams;


import java.util.Collection;
import java.util.Random;

public class WeightedSelector {


  //  protected final static Logger log=Logger.getLogger(WeightedSelector.class);
     Random random=new Random();
     Object[] objects;
     Integer[] weights;
     int maxWeight=0;

    public static void main(String[] args) {

        Integer weights[]= new Integer[]{1,2,3,4,5};
        Object[] objects= new Object[]{'A','B','C'};
        WeightedSelector selector=  new WeightedSelector(objects,weights);
        System.out.printf(selector.flip().toString()); ;
    }


    public WeightedSelector(Object[] objects, Integer[] weights)
    {
        this.objects=objects;
        this.weights=weights;

        for(Integer i : weights)
        {
            maxWeight=maxWeight+i;
        }

       // if(log.isDebugEnabled()) log.debug("Given "+objects.length+" object(s) and "+weights.length+" weight(s), maxWeight: "+maxWeight);

    }

    /**
     * This method is used to return and object based
     * on a random weighted choice.
     *
     * @return
     */
    public Object flip()
    {
        Object retVal=null;

        int pick=random.nextInt(maxWeight);
        int sum=0;
        for(int count=0; count!=weights.length; count++)
        {
            sum=sum+weights[count];
         //   if(log.isDebugEnabled()) log.debug("Random was: "+pick+"     current total is "+sum+"    count is: "+(count+1)+"     max count is: "+(weights.length-1));
            if(pick<=sum)
            {
                retVal=objects[count];
                break;
            }
        }

        if(retVal!=null)
        {
          //  if(log.isDebugEnabled()) log.debug("maxweight: "+maxWeight+"   pick: "+pick+"    retVal: "+retVal.toString());
        }
        else
        {
           // log.error("Flipped and returned null, that shouldn't happen!");
        }
        return retVal;
    }

    /**
     * This method is used when we need to pick from
     * a dynamic list of the specified objects.  The
     * initial setup needs to be igonored and
     * recalculated.
     *
     * @param
     */
    public Object flip(Collection<String> applicableObjects, boolean exclude)
    {
        Object retVal=null;

        //We know that we can't have more objects
        //than we started, and that the weighting
        //value of the new list won't push us
        //into a null object
        int aSize=objects.length;
        Object[] tmpObjs=new Object[aSize];
        Integer[] tmpWeights=new Integer[aSize];
        int newSize=0;
        int newMaxWeight=0;
        //if(log.isDebugEnabled()) log.debug("applicable objects for flip count : "+applicableObjects.size());
        for(int i=0; i<aSize; i++)
        {
            boolean contains=applicableObjects.contains((String)(objects[i]));
            if((contains && !exclude) || (!contains && exclude))
            {
                tmpObjs[newSize]=objects[i];
                tmpWeights[newSize]=weights[i];
                newMaxWeight=newMaxWeight+weights[i];
                newSize++;
            }
            else
            {
                //if(log.isDebugEnabled()) log.debug("Not including "+(String)(objects[i])+" in the applicable objects list");
            }
        }

        if(newMaxWeight==0)
        {
          //  if(log.isDebugEnabled())
            {
              //  log.debug("Weighted selector had excluded all options");

            }
            return null;
        }

        int pick=random.nextInt(newMaxWeight);
        int sum=0;
        for(int count=0; count!=newSize; count++)
        {
            sum=sum+tmpWeights[count];
           // if(log.isDebugEnabled()) log.debug("Random was: "+pick+"     current total is "+sum+"    count is: "+(count+1)+"     max count is: "+(newSize-1));
            if(pick<=sum)
            {
                retVal=tmpObjs[count];
                break;
            }
        }

        //if(log.isDebugEnabled())
        {
            if(retVal!=null)
            {
           //     log.debug("Flipped, returning ssmaxweight: "+newMaxWeight+"   pick: "+pick+"    retVal: "+retVal.toString());
            }
            else
            {
           //     log.debug("Flipped and returned null.");
            }
        }
        return retVal;
    }

    //Atlas.1 : Get the list of assets associated to the rule if assertAsset list is empty
    public Object[] getObjects() {
        return objects;
    }

}
