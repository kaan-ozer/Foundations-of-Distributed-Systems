import axios from 'axios';


class NetworkService {

     httpClient = axios.create({
        headers: {
            "Accept": "application/json",
        }
    });


    getDispatcherState() {
        return this.httpClient.get("http://localhost:8080/exam03/api");
    }

    getAllEventsState(url) {
        return this.httpClient.get(url);
    }

// @@@END

    getSingleEventState(url) {
        return this.httpClient.get(url);
    }

    postSingleEvent(url, event) {
        return this.httpClient.post(url, event);
    }

    updateSingleEvent(url, event) {
        return this.httpClient.put(url, event);
    }

    deleteSingleEvent(url) {
        return this.httpClient.delete(url);
    }


}

export default new NetworkService();
