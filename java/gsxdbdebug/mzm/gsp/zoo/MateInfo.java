/*    */ package mzm.gsp.zoo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class MateInfo implements Marshal
/*    */ {
/*    */   public Octets role_name;
/*    */   public int animal_cfgid;
/*    */   public int mate_time;
/*    */   
/*    */   public MateInfo()
/*    */   {
/* 16 */     this.role_name = new Octets();
/*    */   }
/*    */   
/*    */   public MateInfo(Octets _role_name_, int _animal_cfgid_, int _mate_time_) {
/* 20 */     this.role_name = _role_name_;
/* 21 */     this.animal_cfgid = _animal_cfgid_;
/* 22 */     this.mate_time = _mate_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.role_name);
/* 31 */     _os_.marshal(this.animal_cfgid);
/* 32 */     _os_.marshal(this.mate_time);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.role_name = _os_.unmarshal_Octets();
/* 38 */     this.animal_cfgid = _os_.unmarshal_int();
/* 39 */     this.mate_time = _os_.unmarshal_int();
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 44 */     if (_o1_ == this) return true;
/* 45 */     if ((_o1_ instanceof MateInfo)) {
/* 46 */       MateInfo _o_ = (MateInfo)_o1_;
/* 47 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 48 */       if (this.animal_cfgid != _o_.animal_cfgid) return false;
/* 49 */       if (this.mate_time != _o_.mate_time) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += this.role_name.hashCode();
/* 58 */     _h_ += this.animal_cfgid;
/* 59 */     _h_ += this.mate_time;
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 67 */     _sb_.append(this.animal_cfgid).append(",");
/* 68 */     _sb_.append(this.mate_time).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\MateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */