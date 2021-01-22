import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

@Getter
@Setter
public class Assignment {
    @ToUpper(toUpper = true)
    @XmlElement(name = "Name" )
    private String Name;

    @ToUpper(toUpper = true)
    @XmlElement(name = "Language" )
    private String Language;

    @XmlElement(name = "Status" )
    private String Status;

    @XmlElement(name = "Id")
    private int Id;

    @AddDate(addDate = true)
    private LocalDate localDate = null;




}
