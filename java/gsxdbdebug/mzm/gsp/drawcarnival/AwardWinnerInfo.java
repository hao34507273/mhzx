/*    */ package mzm.gsp.drawcarnival;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class AwardWinnerInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public long role_id;
/*    */   public Octets role_name;
/*    */   public int random_type_id;
/*    */   public long award_count;
/*    */   
/*    */   public AwardWinnerInfo()
/*    */   {
/* 15 */     this.role_name = new Octets();
/*    */   }
/*    */   
/*    */   public AwardWinnerInfo(long _role_id_, Octets _role_name_, int _random_type_id_, long _award_count_) {
/* 19 */     this.role_id = _role_id_;
/* 20 */     this.role_name = _role_name_;
/* 21 */     this.random_type_id = _random_type_id_;
/* 22 */     this.award_count = _award_count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.role_id);
/* 31 */     _os_.marshal(this.role_name);
/* 32 */     _os_.marshal(this.random_type_id);
/* 33 */     _os_.marshal(this.award_count);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     this.role_id = _os_.unmarshal_long();
/* 39 */     this.role_name = _os_.unmarshal_Octets();
/* 40 */     this.random_type_id = _os_.unmarshal_int();
/* 41 */     this.award_count = _os_.unmarshal_long();
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 46 */     if (_o1_ == this) return true;
/* 47 */     if ((_o1_ instanceof AwardWinnerInfo)) {
/* 48 */       AwardWinnerInfo _o_ = (AwardWinnerInfo)_o1_;
/* 49 */       if (this.role_id != _o_.role_id) return false;
/* 50 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 51 */       if (this.random_type_id != _o_.random_type_id) return false;
/* 52 */       if (this.award_count != _o_.award_count) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += (int)this.role_id;
/* 61 */     _h_ += this.role_name.hashCode();
/* 62 */     _h_ += this.random_type_id;
/* 63 */     _h_ += (int)this.award_count;
/* 64 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuilder _sb_ = new StringBuilder();
/* 69 */     _sb_.append("(");
/* 70 */     _sb_.append(this.role_id).append(",");
/* 71 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 72 */     _sb_.append(this.random_type_id).append(",");
/* 73 */     _sb_.append(this.award_count).append(",");
/* 74 */     _sb_.append(")");
/* 75 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\AwardWinnerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */