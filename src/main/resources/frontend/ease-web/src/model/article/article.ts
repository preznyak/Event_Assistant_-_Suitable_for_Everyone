import {User} from "../user/user";
import DateTimeFormat = Intl.DateTimeFormat;

export class Article {
  articleId: string;
  title: string;
  content: string;
  youtubeLink: string;
  user: User;
  creationTime: Date;
}
