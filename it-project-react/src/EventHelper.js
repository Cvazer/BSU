class EventHelper {
    static getLocalType(type){
        let localType = '';
        switch (type) {
            case 'MOVIE':
                localType = 'Кино';
                break;
            case 'CONCERT':
                localType = 'Концерт';
                break;
            case 'PLAY':
                localType = 'Пьеса';
                break;
            default:
                localType = 'Другое';
                break
        }
        return localType;
    }

    static getColor(type){
        let color = '';
        switch (type) {
            case 'MOVIE':
                color = '#00C955';
                break;
            case 'CONCERT':
                color = '#FF9E00';
                break;
            case 'PLAY':
                color = '#A51100';
                break;
            default:
                color = '#006DA5';
                break
        }
        return color;
    }


    static getTagsString(tags){
        let tagsString = '';
        tags.forEach(
            (tag) => {
                tagsString+=tag.name+', ';
            }
        );
        tagsString = tagsString.substring(0,tagsString.length-2);
        return tagsString;
    }
}

export default EventHelper;