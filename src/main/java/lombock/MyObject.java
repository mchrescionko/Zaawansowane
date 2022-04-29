package lombock;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyObject {
    private int firstInt;
    private int secondInt;
    private String firstString;
}
