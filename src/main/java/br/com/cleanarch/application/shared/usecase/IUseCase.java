package br.com.cleanarch.application.shared.usecase;

import br.com.cleanarch.application.shared.output.IOutput;

public interface IUseCase<O extends IOutput> {

    O execute();

}
