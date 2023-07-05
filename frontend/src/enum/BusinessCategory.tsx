import {MdBakeryDining, MdFlightTakeoff, MdOutlineVilla} from "react-icons/md";
import {
    GiAmpleDress,
    GiChurch,
    GiLinkedRings,
    GiLipstick,
    GiPapers, GiPartyPopper,
    GiPhotoCamera, GiPorcelainVase,
    GiTrumpet,
    GiWindmill
} from "react-icons/gi";
import {ImHeadphones, ImVideoCamera} from "react-icons/im";
import {FaUserTie} from "react-icons/fa";
import {BsScissors} from "react-icons/bs";
import {PiFlowerLotusThin, PiFlowerTulipDuotone} from "react-icons/pi";
import {BiHotel, BiSolidDrink, BiSolidMicrophone} from "react-icons/bi";
import {AiFillCar, AiOutlineSchedule} from "react-icons/ai";
import {IoIosRestaurant} from "react-icons/io";
import {FaPlateWheat} from "react-icons/fa6";

export enum BusinessCategory {
    PHOTOGRAPHER,
    VIDEOGRAPHER,
    BEAUTY_SALON,
    DRESSES,
    SUITS,
    HAIR_DRESSER,
    DECOR_LIGHTNING,
    DJ,
    MUSICIAN,
    FLORIST,
    JEWELER,
    CEREMONY_VENUE,
    WEDDING_VENUE,
    CATERER,
    HOTEL_ROOMS,
    BAKERY,
    TRANSPORTATION,
    TRAVEL_AGENT,
    ACCESSOIRES_FAVORS,
    WEDDING_PLANNER,
    INVITATION_PAPER_GOODS,
    BAR_SERVICE,
    ENTERTAINMENT,
    RESTAURANT
}

export const businessCategories = [
    {
        label: 'PHOTOGRAPHER',
        icon: GiPhotoCamera,
        description: '',
    },
    {
        label: 'VIDEOGRAPHER',
        icon: ImVideoCamera,
        description: '',
    },
    {
        label: 'BEAUTY_SALON',
        icon: GiLipstick,
        description: ''
    },
    {
        label: 'DRESSES',
        icon: GiAmpleDress,
        description: ''
    },
    {
        label: 'SUITS',
        icon: FaUserTie,
        description: ''
    },
    {
        label: 'HAIR_DRESSER',
        icon: BsScissors,
        description: ''
    },
    {
        label: 'DECOR_LIGHTNING',
        icon: GiPorcelainVase,
        description: ''
    },
    {
        label: 'DJ',
        icon: ImHeadphones,
        description: ''
    },
    {
        label: 'MUSICIAN',
        icon: GiTrumpet,
        description: ''
    },
    {
        label: 'FLORIST',
        icon: PiFlowerTulipDuotone,
        description: ''
    },
    {
        label: 'JEWELER',
        icon: GiLinkedRings,
        description: ''
    },
    {
        label: 'CEREMONY_VENUE',
        icon: GiChurch,
        description: ''
    },
    {
        label: 'WEDDING_VENUE',
        icon: GiPartyPopper,
        description: ''
    },
    {
        label: 'CATERER',
        icon: FaPlateWheat,
        description: ''
    },
    {
        label: 'HOTEL_ROOMS',
        icon: BiHotel,
        description: ''
    },
    {
        label: 'BAKERY',
        icon: MdBakeryDining,
        description: ''
    },
    {
        label: 'TRANSPORTATION',
        icon: AiFillCar,
        description: ''
    },
    {
        label: 'TRAVEL_AGENT',
        icon: MdFlightTakeoff,
        description: ''
    },
    {
        label: 'ACCESSOIRES_FAVORS',
        icon: PiFlowerLotusThin,
        description: ''
    },
    {
        label: 'WEDDING_PLANNER',
        icon: AiOutlineSchedule,
        description: ''
    },
    {
        label: 'INVITATION_PAPER_GOODS',
        icon: GiPapers,
        description: ''
    },
    {
        label: 'BAR_SERVICE',
        icon: BiSolidDrink,
        description: ''
    },
    {
        label: 'ENTERTAINMENT',
        icon: BiSolidMicrophone,
        description: ''
    },
    {
        label: 'RESTAURANT',
        icon: IoIosRestaurant,
        description: ''
    }
]