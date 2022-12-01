package ua.karatnyk;

import org.junit.jupiter.api.Test;
import ua.karatnyk.impl.CurrencyConversion;
import ua.karatnyk.impl.CurrencyConvertor;
import ua.karatnyk.impl.OfflineJsonWorker;

import java.text.ParseException;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class TestCurrencyConvertor {

    // black box tests
    @Test
    void testConvert1(){
        OfflineJsonWorker  manager = new OfflineJsonWorker();
        CurrencyConversion conversion = manager.parser();
        try{
            double res = CurrencyConvertor.convert(1,"USD" ,"CAD" ,conversion);
            assertTrue(res>0);
        } catch (ParseException e){
            ParseException expected = new ParseException("Not correct format currency"
                    + "", 0);
            fail("unsupported currency");
        }
    }
    @Test
    void testConvert2(){
        OfflineJsonWorker  manager = new OfflineJsonWorker();
        CurrencyConversion conversion = manager.parser();
        try{
            double res = CurrencyConvertor.convert(1,"GBP" ,"EUR" ,conversion);
            assertTrue(res>0);
        } catch (ParseException e){
            ParseException expected = new ParseException("Not correct format currency"
                    + "", 0);
            fail("unsupported currency");
        }
    }
    @Test
    void testConvert3(){
        OfflineJsonWorker  manager = new OfflineJsonWorker();
        CurrencyConversion conversion = manager.parser();
        try{
            double res = CurrencyConvertor.convert(1,"CHF" ,"INR" ,conversion);
            assertTrue(res>0);
        } catch (ParseException e){
            ParseException expected = new ParseException("Not correct format currency"
                    + "", 0);
            fail("unsupported currency");
        }
    }
    @Test
    void testConvert4(){
        OfflineJsonWorker  manager = new OfflineJsonWorker();
        CurrencyConversion conversion = manager.parser();
        try{
            double res = CurrencyConvertor.convert(1,"FJD" ,"AUD" ,conversion);
            fail("unexpected supported currency");
        } catch (ParseException e){
            ParseException expected = new ParseException("Not correct format currency"
                    + "", 0);
            assertEquals(e.getMessage(),expected.getMessage());
        }
    }
    @Test
    void testConvert5(){
        OfflineJsonWorker  manager = new OfflineJsonWorker();
        CurrencyConversion conversion = manager.parser();
        try{
            double res = CurrencyConvertor.convert(1,"EUR" ,"AUD" ,conversion);
            assertTrue(res>0);
        } catch (ParseException e){
            ParseException expected = new ParseException("Not correct format currency"
                    + "", 0);
            fail("unexpected supported currency");
        }
    }
    @Test
    void testConvert6(){
        OfflineJsonWorker  manager = new OfflineJsonWorker();
        CurrencyConversion conversion = manager.parser();
        try{
            double res = CurrencyConvertor.convert(0,"USD" ,"EUR" ,conversion);
            assertTrue(res==0);
        } catch (ParseException e){
            ParseException expected = new ParseException("Not correct format currency"
                    + "", 0);
            fail("unsupported currency");
        }
    }
    @Test
    void testConvert7(){
        OfflineJsonWorker  manager = new OfflineJsonWorker();
        CurrencyConversion conversion = manager.parser();
        try{
            double res = CurrencyConvertor.convert(10000,"USD" ,"EUR" ,conversion);
            assertTrue(res>0);
        } catch (ParseException e){
            ParseException expected = new ParseException("Not correct format currency"
                    + "", 0);
            fail("unsupported currency");
        }
    }
    @Test
    void testConvert8(){
        OfflineJsonWorker  manager = new OfflineJsonWorker();
        CurrencyConversion conversion = manager.parser();
        try{
            double res = CurrencyConvertor.convert(-1,"USD" ,"EUR" ,conversion);
            assertFalse(res<0);
        } catch (ParseException e){
            ParseException expected = new ParseException("Not correct format currency"
                    + "", 0);
            fail("unsupported currency");
        }
    }
    @Test
    void testConvert9(){
        OfflineJsonWorker  manager = new OfflineJsonWorker();
        CurrencyConversion conversion = manager.parser();
        try{
            double res = CurrencyConvertor.convert(10001,"USD" ,"EUR" ,conversion);
            assertFalse(res>0);
        } catch (ParseException e){
            ParseException expected = new ParseException("Not correct format currency"
                    + "", 0);
            fail("unsupported currency");
        }
    }
}