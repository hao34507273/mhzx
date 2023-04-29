/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class NotifyCrossBattleFinalBulletion implements Marshal
/*    */ {
/*    */   public int zone_id;
/*    */   public Octets bulletin_content;
/*    */   
/*    */   public NotifyCrossBattleFinalBulletion()
/*    */   {
/* 15 */     this.bulletin_content = new Octets();
/*    */   }
/*    */   
/*    */   public NotifyCrossBattleFinalBulletion(int _zone_id_, Octets _bulletin_content_) {
/* 19 */     this.zone_id = _zone_id_;
/* 20 */     this.bulletin_content = _bulletin_content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.zone_id);
/* 29 */     _os_.marshal(this.bulletin_content);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.zone_id = _os_.unmarshal_int();
/* 35 */     this.bulletin_content = _os_.unmarshal_Octets();
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 40 */     if (_o1_ == this) return true;
/* 41 */     if ((_o1_ instanceof NotifyCrossBattleFinalBulletion)) {
/* 42 */       NotifyCrossBattleFinalBulletion _o_ = (NotifyCrossBattleFinalBulletion)_o1_;
/* 43 */       if (this.zone_id != _o_.zone_id) return false;
/* 44 */       if (!this.bulletin_content.equals(_o_.bulletin_content)) return false;
/* 45 */       return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 51 */     int _h_ = 0;
/* 52 */     _h_ += this.zone_id;
/* 53 */     _h_ += this.bulletin_content.hashCode();
/* 54 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 58 */     StringBuilder _sb_ = new StringBuilder();
/* 59 */     _sb_.append("(");
/* 60 */     _sb_.append(this.zone_id).append(",");
/* 61 */     _sb_.append("B").append(this.bulletin_content.size()).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\NotifyCrossBattleFinalBulletion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */