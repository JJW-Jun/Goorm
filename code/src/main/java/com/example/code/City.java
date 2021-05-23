package com.example.code;

import lombok.Getter;
import lombok.NonNull;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum City {
    // 특별시(1) : 서울
    SEOUL("서울", 11),

    // 광역시(6) : 부산, 대구, 인천, 광주, 대전, 울산
    BUSAN("부산", 21), DAEGU("대구", 22), INCHEON("인천", 23),
    GWANGJU("광주", 24), DAEJEON("대전", 25), ULSAN("울산", 26),

    // 특별자치시(1) : 세종
    SEJONG_SI("세종", 29),

    // 도(8) : 경기도, 강원도, 충청북도, 충청남도, 전라북도, 전라남도, 경상북도, 경상남도
    GYEONGGI_DO("경기도", 31), GANGWON_DO("강원도", 32), CHUNGCHEONGBUK_DO("충청북도", 33),
    CHUNGCHEONGNAM_DO("충청남도", 34), JEOLLABUK_DO("전라북도", 35), JEOLLANAM_DO("전라남도", 36),
    GYEONGSANGBUK_DO("경상북도", 37), GYEONGSANGNAM_DO("경상남도", 38),

    // 특별자치도(1) : 제주도
    JEJU_DO("제주도", 39),

    //
    UNKOWN("없음", 0);
    private final String cityName;
    private final int cityCode;

    City(String cityName, int cityCode) {
        this.cityName = cityName;
        this.cityCode = cityCode;
    }

//    public static boolean findCityCode(String cityName) {
//        return Arrays.stream(Cities.values())
//                .anyMatch(Cities -> Cities.getCityName().equals(cityName));
//    }

    //    public static int findCityCode(String name) {
//        return Arrays.stream(Cities.values())
//                .filter(Cities -> Cities.getCityName().equals(name))
//                .mapToInt(Cities::getCityCode)
//                .findAny()
//                .orElseThrow(IllegalStateException::new);
//    }
    public static int findCityCode(String city) {
        return Arrays.stream(City.values())
                .filter(City -> City.getCityName().equals(city))
                .mapToInt(City::getCityCode)
                .findAny()
                .orElseGet(() -> UNKOWN.cityCode);
    }

    private static final Map<String, City> descriptions
            = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(City::getCityName, Function.identity())));

    public static int find(String description) {
        return descriptions.get(description).getCityCode();
    }


    public static void main(String args[]) {
        findCityCode("부산");
        System.out.println(findCityCode("서울"));
        System.out.println(find("서울"));
    }


}


/*
< 연관성 있는 데이터 참조 >
보다 정확한 기능구현을 위해 enum으로 행정구역(CityType)이 도시명(CityName)을 참조하도록 했지만
사용하지 않는 관계로 아래로 내렸습니다.
https://elaw.klri.re.kr/kor_service/local.do
 */
@Getter
enum CityType {
    // 특별시(1) : 서울
    SPECIAL_CITY("특별시", Arrays.asList(City.SEOUL)),

    // 광역시(6) : 부산, 대구, 인천, 광주, 대전, 울산
    METROPOLITAN_CITY("광역시", Arrays.asList(City.BUSAN, City.DAEGU, City.INCHEON, City.GWANGJU,
            City.DAEJEON, City.ULSAN)),

    // 특별자치시(1) : 세종
    METROPOLITAN_AUTONOMOUS_CITY("특별자치시", Arrays.asList(City.SEJONG_SI)),

    // 도(8) : 경기도, 강원도, 충청북도, 충청남도, 전라북도, 전라남도, 경상북도, 경상남도
    PROVINCE("도", Arrays.asList(City.GYEONGGI_DO, City.GANGWON_DO, City.CHUNGCHEONGBUK_DO,
            City.CHUNGCHEONGNAM_DO, City.JEOLLABUK_DO, City.JEOLLANAM_DO, City.GYEONGSANGBUK_DO,
            City.GYEONGSANGNAM_DO)),

    // 특별자치도(1) : 제주도
    SPECIAL_SELF_GOVERNING_PROVINCE("특별자치도", Arrays.asList(City.JEJU_DO)),
    EMPTY("없음", Collections.emptyList());

    private final String cityType;
    private final List<City> cities;

    CityType(String cityType, List<City> cities) {
        this.cityType = cityType;
        this.cities = cities;
    }

    public boolean cities(City name) {
        return cities.stream()
                .anyMatch(city -> city == name);
    }

    public boolean cities2(City ccc) {
        return Arrays.stream(City.values()).anyMatch(city -> city.getCityName().equals(ccc.getCityName()));
    }

    public static CityType findCityCode(@NonNull City city) {
        return Arrays.stream(CityType.values())
                .filter(x -> x.cities2(city))
                .findAny()
                .orElse(EMPTY);

    }

    public static void main(String args[]) {
        System.out.println(findCityCode(City.BUSAN));
    }

//
//    public static CityType findCity(Cities name) {
//        return Arrays.stream(CityType.values())
//                .filter(x -> x.nameIs(name))
//                .findAny().orElseThrow(IllegalAccessError::new);
//    }
//
//    public static int findCityCode(String cityName) {
//        return Arrays.stream(CityType.values())
//                .filter(City -> City.nameIs(cityName))
//
//    }

    //    public static int findCityCode(Cities name) {
//        return Arrays.stream(CityType.values())
//                .filter(x->x.nameIs(name))
//    }
//    public boolean nameIs(String name) {
//        return cities.stream()
//                .anyMatch(city -> city.getCityName() == name);
//    }


    //
//    public boolean codeIs(Cities code){
//        return cities.stream()
//                .anyMatch(city->);
//
//    }


}



