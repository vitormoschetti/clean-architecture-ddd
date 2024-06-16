package br.com.cleanarch.application.shared.usecase;

import br.com.cleanarch.application.shared.input.IInput;
import br.com.cleanarch.application.shared.output.IOutput;

public interface IUseCaseWithParam<I extends IInput, O extends IOutput> {

    O execute(I param);

}
