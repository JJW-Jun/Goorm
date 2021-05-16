package builder.second;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private final Long id;
    private String name;

    @Builder
    public MemberDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }



//    public Member toEntity(Member member){
//        return Member.builder()
//    }

}

//    public static class Builder implements CommonBuilder {
//        private Long id;
//        private final String name;
//        private final String password;
//        private final String email;
//        private String address;
//        private String gender;
//
//        @lombok.Builder
//        public Builder(String name, String password, String email,
//                       String address, String gender) {
//            this.name = name;
//            this.password = password;
//            this.email = email;
//            this.address = address;
//            this.gender = gender;
//        }
////
////        public Builder address(String address) {
////            this.address = address;
////            return this;
////        }
////
////        public Builder gender(String gender) {
////            this.gender = gender;
////            return this;
////        }
//
//        @Override
//        public MemberDto build() {
//            return new MemberDto(this);
//        }
//    }


//    MemberDto(Builder builder) {
//        this.id = builder.id;
//        this.name = builder.name;
//        this.password = builder.password;
//        this.email = builder.email;
//        this.address = builder.address;
//        this.gender = builder.gender;
//    }

//}