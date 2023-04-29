/*    */ package mzm.gsp.countdown.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ThankMail implements Marshal
/*    */ {
/*    */   public int send_thank_mail_timestamp_year;
/*    */   public int send_thank_mail_timestamp_month;
/*    */   public int send_thank_mail_timestamp_day;
/*    */   public int send_thank_mail_timestamp_hour;
/*    */   public int send_thank_mail_timestamp_minute;
/*    */   public int send_thank_mail_timestamp_second;
/*    */   public int thank_mail_cfg_id;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 19 */     this.send_thank_mail_timestamp_year = Integer.valueOf(rootElement.attributeValue("send_thank_mail_timestamp_year")).intValue();
/* 20 */     this.send_thank_mail_timestamp_month = Integer.valueOf(rootElement.attributeValue("send_thank_mail_timestamp_month")).intValue();
/* 21 */     this.send_thank_mail_timestamp_day = Integer.valueOf(rootElement.attributeValue("send_thank_mail_timestamp_day")).intValue();
/* 22 */     this.send_thank_mail_timestamp_hour = Integer.valueOf(rootElement.attributeValue("send_thank_mail_timestamp_hour")).intValue();
/* 23 */     this.send_thank_mail_timestamp_minute = Integer.valueOf(rootElement.attributeValue("send_thank_mail_timestamp_minute")).intValue();
/* 24 */     this.send_thank_mail_timestamp_second = Integer.valueOf(rootElement.attributeValue("send_thank_mail_timestamp_second")).intValue();
/* 25 */     this.thank_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("thank_mail_cfg_id")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 30 */     _os_.marshal(this.send_thank_mail_timestamp_year);
/* 31 */     _os_.marshal(this.send_thank_mail_timestamp_month);
/* 32 */     _os_.marshal(this.send_thank_mail_timestamp_day);
/* 33 */     _os_.marshal(this.send_thank_mail_timestamp_hour);
/* 34 */     _os_.marshal(this.send_thank_mail_timestamp_minute);
/* 35 */     _os_.marshal(this.send_thank_mail_timestamp_second);
/* 36 */     _os_.marshal(this.thank_mail_cfg_id);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 42 */     this.send_thank_mail_timestamp_year = _os_.unmarshal_int();
/* 43 */     this.send_thank_mail_timestamp_month = _os_.unmarshal_int();
/* 44 */     this.send_thank_mail_timestamp_day = _os_.unmarshal_int();
/* 45 */     this.send_thank_mail_timestamp_hour = _os_.unmarshal_int();
/* 46 */     this.send_thank_mail_timestamp_minute = _os_.unmarshal_int();
/* 47 */     this.send_thank_mail_timestamp_second = _os_.unmarshal_int();
/* 48 */     this.thank_mail_cfg_id = _os_.unmarshal_int();
/* 49 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\confbean\ThankMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */