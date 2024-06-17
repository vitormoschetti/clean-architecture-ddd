package br.com.cleanarch.application.shared.usecase;

public interface IUseCaseWithParam<Inp, Out> {

    Out execute(Inp param);

}
