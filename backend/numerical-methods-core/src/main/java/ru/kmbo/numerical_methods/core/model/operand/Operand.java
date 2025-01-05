package ru.kmbo.numerical_methods.core.model.operand;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.kmbo.numerical_methods.core.model.operand.implementation.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Add.class, name = "Add"),
    @JsonSubTypes.Type(value = Cos.class, name = "Cos"),
    @JsonSubTypes.Type(value = Exp.class, name = "Exp"),
    @JsonSubTypes.Type(value = Multiply.class, name = "Multiply"),
    @JsonSubTypes.Type(value = Neg.class, name = "Neg"),
    @JsonSubTypes.Type(value = Num.class, name = "Num"),
    @JsonSubTypes.Type(value = Pow.class, name = "Pow"),
    @JsonSubTypes.Type(value = Sin.class, name = "Sin"),
    @JsonSubTypes.Type(value = Variable.class, name = "Variable"),
    @JsonSubTypes.Type(value = Ln.class, name = "Ln"),
})
public interface Operand {

    public Double getResult();
}
