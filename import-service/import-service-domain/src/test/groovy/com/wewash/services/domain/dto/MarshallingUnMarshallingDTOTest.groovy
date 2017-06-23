package com.wewash.services.domain.dto

import com.wewash.services.domain.dto.fixture.Event
import com.wewash.services.domain.dto.marketset.MarketSetMessage
import com.wewash.services.domain.dto.matchdetails.FootballMatchDetailsMessage
import com.wewash.services.domain.dto.resultset.ResultSetMessage
import spock.lang.Specification


class MarshallingUnMarshallingDTOTest extends Specification{

    def "should marshall and unmarshall when reading from file DTOs correctly" () {
        given:
        String betgeniusJson = JsonMapper.readFile("${dtoName}", MarshallingUnMarshallingDTOTest.class)
        Object dto = JsonMapper.mapString(betgeniusJson, dtoClass)
        String marshalledJson = JsonMapper.mapObject(dto)

        expect:
        marshalledJson != null

        where:
        dtoName                     | dtoClass
        "fixture.json"              | Event.class
        "resultSet.json"            | ResultSetMessage.class
        "matchdetails.json"         | FootballMatchDetailsMessage.class
        "matchdetails-long.json"    | FootballMatchDetailsMessage.class
        "marketset-regular.json"    | MarketSetMessage.class
        "marketset-range.json"      | MarketSetMessage.class

    }

    def "should marshall and unmarshall correctly when reading from classpath DTOs correctly" () {
        given:
        Object dto = JsonMapper.readFromClassPath(MarshallingUnMarshallingDTOTest.class,"${dtoName}", dtoClass)
        String marshalledJson = JsonMapper.mapObject(dto)

        expect:
        marshalledJson != null

        where:
        dtoName                     | dtoClass
        "fixture.json"              | Event.class
        "resultSet.json"            | ResultSetMessage.class
        "matchdetails.json"         | FootballMatchDetailsMessage.class
        "matchdetails-long.json"    | FootballMatchDetailsMessage.class
        "marketset-regular.json"    | MarketSetMessage.class
        "marketset-range.json"      | MarketSetMessage.class

    }


}
