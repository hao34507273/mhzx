/*    */ package mzm.gsp.mail;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ThingBean
/*    */   implements Marshal, Comparable<ThingBean>
/*    */ {
/*    */   public static final int MAIL_ATTACHMENT_MONEY = 1;
/*    */   public static final int MAIL_ATTACHMENT_TOKEN = 2;
/*    */   public static final int MAIL_ATTACHMENT_EXP = 3;
/*    */   public static final int MAIL_ATTACHMENT_VIGOR = 4;
/*    */   public static final int MAIL_ATTACHMENT_STORE_EXP = 5;
/*    */   public int id;
/*    */   public int count;
/*    */   public int thingtype;
/*    */   
/*    */   public ThingBean() {}
/*    */   
/*    */   public ThingBean(int _id_, int _count_, int _thingtype_)
/*    */   {
/* 23 */     this.id = _id_;
/* 24 */     this.count = _count_;
/* 25 */     this.thingtype = _thingtype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.id);
/* 34 */     _os_.marshal(this.count);
/* 35 */     _os_.marshal(this.thingtype);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.id = _os_.unmarshal_int();
/* 41 */     this.count = _os_.unmarshal_int();
/* 42 */     this.thingtype = _os_.unmarshal_int();
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof ThingBean)) {
/* 49 */       ThingBean _o_ = (ThingBean)_o1_;
/* 50 */       if (this.id != _o_.id) return false;
/* 51 */       if (this.count != _o_.count) return false;
/* 52 */       if (this.thingtype != _o_.thingtype) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += this.id;
/* 61 */     _h_ += this.count;
/* 62 */     _h_ += this.thingtype;
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.id).append(",");
/* 70 */     _sb_.append(this.count).append(",");
/* 71 */     _sb_.append(this.thingtype).append(",");
/* 72 */     _sb_.append(")");
/* 73 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ThingBean _o_) {
/* 77 */     if (_o_ == this) return 0;
/* 78 */     int _c_ = 0;
/* 79 */     _c_ = this.id - _o_.id;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     _c_ = this.count - _o_.count;
/* 82 */     if (0 != _c_) return _c_;
/* 83 */     _c_ = this.thingtype - _o_.thingtype;
/* 84 */     if (0 != _c_) return _c_;
/* 85 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\ThingBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */