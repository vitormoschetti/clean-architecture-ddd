package br.com.cleanarch.application.portfolio.usecase;

import br.com.cleanarch.application.shared.usecase.IUseCaseWithParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PortfolioBuyItemUseCase implements IUseCaseWithParam<PortfolioBuyItemInput, Void> {

    @Override
    public Void execute(PortfolioBuyItemInput param) {
        return null;
    }

}
