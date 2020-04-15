import {User} from "../user/user";

export class Article {
  articleId: string;
  title: string;
  content: string;
  youtubeLink: string;
  user: User;
  creationTime: Date;
}
