package br.com.valkiria.service;

import br.com.valkiria.model.UserModel;
import br.com.valkiria.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<UserModel> create(UserModel userModel) {
        Optional<UserModel> userOptionalUsingEmail = userRepository.findByEmail(userModel.getEmail());
        if(userOptionalUsingEmail.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"");
        }
        else{
            Optional<UserModel> userOptionalUsingCpf = userRepository.findByCpf(userModel.getCpf());
            if(userOptionalUsingCpf.isPresent()) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "");
            }
            else{
                String PwdEncrypted = BCrypt.hashpw(userModel.getPassword(), BCrypt.gensalt());
                userModel.setPassword(PwdEncrypted);
                return ResponseEntity.ok(userRepository.save(userModel));
            }
        }
    }

    public ResponseEntity<UserModel> getById(UUID id) {
        Optional<UserModel> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Registro não encontrado");
        }
    }

    public ResponseEntity<List<UserModel>> getAll() {
        List<UserModel> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }



}
