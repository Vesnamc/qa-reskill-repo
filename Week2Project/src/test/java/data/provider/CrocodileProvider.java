package data.provider;

import com.github.javafaker.Faker;
import common.ValueChoosers;
import data.models.CommonCrocodileRequest;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

public class CrocodileProvider {

    final static public FastDateFormat DF = FastDateFormat.getInstance("yyyy-MM-dd");

    public static CommonCrocodileRequest prepareCrocodile(){
        CommonCrocodileRequest commonCrocodileRequest = new CommonCrocodileRequest();
        commonCrocodileRequest.setName(Faker.instance().gameOfThrones().character());
        commonCrocodileRequest.setSex(ValueChoosers.getRandomSex());
        Date birthday = Faker.instance().date().birthday();
        String birthdayStr = DF.format(birthday);
        commonCrocodileRequest.setDateOfBirth(birthdayStr);

        return commonCrocodileRequest;
    }
}
