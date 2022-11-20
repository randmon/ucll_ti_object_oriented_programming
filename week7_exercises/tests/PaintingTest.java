import domain.kunstwerken.Painting;
import domain.utils.DomainException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.Euro;

public class PaintingTest {
    private Painting p1;

    @Before
    public void setUp() {
        p1 = new Painting("A", "A", 1000, 1000, new Euro(1000));
    }

    //TEST CONSTRUCTOR
    @Test(expected = DomainException.class)
    public void painting_emptyArtist_throwsException() {
        new Painting("", "A", 1000, 1000, new Euro(1000));
    }

    @Test (expected = DomainException.class)
    public void painting_nullArtist_throwsException() {
        new Painting(null, "A", 1000, 1000, new Euro(1000));
    }

    @Test (expected = DomainException.class)
    public void painting_emptyTitle_throwsException() {
        new Painting("A", "", 1000, 1000, new Euro(1000));
    }

    @Test (expected = DomainException.class)
    public void painting_nullTitle_throwsException() {
        new Painting("A", null, 1000, 1000, new Euro(1000));
    }

    @Test (expected = DomainException.class)
    public void painting_negHeight_throwsException() {
        new Painting("A", "A", -1000, 1000, new Euro(1000));
    }

    @Test (expected = DomainException.class)
    public void painting_zeroHeight_throwsException() {
        new Painting("A", "A", 0, 1000, new Euro(1000));
    }

    @Test
    public void painting_smallHeight() {
        new Painting("A", "A", 1, 1000, new Euro(1000));
    }

    @Test
    public void painting_largeHeight() {
        new Painting("A", "A", 1000000, 1000, new Euro(1000));
    }

    @Test (expected = DomainException.class)
    public void painting_negativeValue_throwsException() {
        new Painting("A", "A", 1000, 1000, new Euro(-1000));
    }

    @Test (expected = DomainException.class)
    public void painting_zeroValue_throwsException() {
        new Painting("A", "A", 1000, 1000, new Euro(0));
    }

    //TEST setValue

    @Test (expected = DomainException.class)
    public void setValue_negative_throwsException() {
        p1.setValue(new Euro(-1000));
    }

    @Test (expected = DomainException.class)
    public void setValue_zero_throwsException() {
        p1.setValue(new Euro(0));
    }

    @Test
    public void setValue_changesValue() {
        p1.setValue(new Euro(100));
        Assert.assertEquals(new Euro(100), p1.getValue());
    }

    @Test
    public void getPrice_calculatesPriceCorrectly() {
        Assert.assertEquals(p1.getPrice(), p1.getValue().multiply(1.10));
        p1.setValue(new Euro(100));
        Assert.assertEquals(p1.getPrice(), new Euro(110));
    }
}