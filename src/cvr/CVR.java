package cvr;

import avl.AVL;
import sequence.Sequence;

import java.util.ArrayList;

public class CVR {
    private long threshold;
    private int keyLength;
    private int size = 0;
    private final AVL avl = new AVL();
    private final Sequence sequence = new Sequence();

    public CVR(){
        threshold = 100000;
        keyLength = 14;
    }

    public CVR(long threshold, int keyLength) throws KeyLengthOutOfBoundsException, ThresholdOutOfBoundsException {
        setKeyLength(keyLength);
        setThreshold(threshold);
    }

    /**
     *
     * @param threshold limit between sequence and AVL
     * @throws ThresholdOutOfBoundsException threshold is too large or too small
     */
    public void setThreshold(long threshold) throws ThresholdOutOfBoundsException {
        if (threshold < 100 || threshold > 900000)
            throw new ThresholdOutOfBoundsException(threshold);
        this.threshold = threshold;
    }

    /**
     *
     * @param keyLength keylength of the vehicles for the data structure
     * @throws KeyLengthOutOfBoundsException the keylength is too short or too long
     */
    public void setKeyLength(int keyLength) throws KeyLengthOutOfBoundsException {
        if (keyLength < 10 || keyLength > 17)
            throw new KeyLengthOutOfBoundsException(keyLength);
        this.keyLength = keyLength;
    }

    public void generate(int n){

    }

    public boolean usingSequence() {
        return size < threshold;
    }

    public boolean usingAVL() {
        return size >= threshold;
    }

    public ArrayList<String> allKeys() {
        if(usingSequence())
            return sequence.allKeys();
        else
            return avl.allKeys();
    }
}
