package com.jvmbrg.dsfCrudClient.service;

import com.jvmbrg.dsfCrudClient.dto.ClientDTO;
import com.jvmbrg.dsfCrudClient.entities.Client;
import com.jvmbrg.dsfCrudClient.repository.ClientRepository;
import com.jvmbrg.dsfCrudClient.service.exceptions.NoSuchElementException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client result = clientRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Recurso não encontrado"));
        return new ClientDTO(result);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
       Client entity = new Client();
       copyDtoToEntity(dto, entity);
       entity = clientRepository.save(entity);
       return new ClientDTO(entity);

    }

    @Transactional
    public ClientDTO update(Long id,ClientDTO dto){
        try {
            Client entity = clientRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = clientRepository.save(entity);
            return new ClientDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new NoSuchElementException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!clientRepository.existsById(id)){
            throw new NoSuchElementException("Recurso não encontrado");
        }
            clientRepository.deleteById(id);
    }



    private void copyDtoToEntity(ClientDTO dto, Client entity){
        entity.setName(dto.getName());
        entity.setChildren(dto.getChildren());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
    }





}
