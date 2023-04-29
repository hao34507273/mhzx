/*    */ package mzm.gsp.leitai;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class LeiTaiFightInfo implements Marshal
/*    */ {
/*    */   public LeiTaiRoleInfo activeroleinfo;
/*    */   public int activeteamnum;
/*    */   public LeiTaiRoleInfo passiveroleinfo;
/*    */   public int passiveteamnum;
/*    */   
/*    */   public LeiTaiFightInfo()
/*    */   {
/* 15 */     this.activeroleinfo = new LeiTaiRoleInfo();
/* 16 */     this.passiveroleinfo = new LeiTaiRoleInfo();
/*    */   }
/*    */   
/*    */   public LeiTaiFightInfo(LeiTaiRoleInfo _activeroleinfo_, int _activeteamnum_, LeiTaiRoleInfo _passiveroleinfo_, int _passiveteamnum_) {
/* 20 */     this.activeroleinfo = _activeroleinfo_;
/* 21 */     this.activeteamnum = _activeteamnum_;
/* 22 */     this.passiveroleinfo = _passiveroleinfo_;
/* 23 */     this.passiveteamnum = _passiveteamnum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     if (!this.activeroleinfo._validator_()) return false;
/* 28 */     if (!this.passiveroleinfo._validator_()) return false;
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.activeroleinfo);
/* 34 */     _os_.marshal(this.activeteamnum);
/* 35 */     _os_.marshal(this.passiveroleinfo);
/* 36 */     _os_.marshal(this.passiveteamnum);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.activeroleinfo.unmarshal(_os_);
/* 42 */     this.activeteamnum = _os_.unmarshal_int();
/* 43 */     this.passiveroleinfo.unmarshal(_os_);
/* 44 */     this.passiveteamnum = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof LeiTaiFightInfo)) {
/* 51 */       LeiTaiFightInfo _o_ = (LeiTaiFightInfo)_o1_;
/* 52 */       if (!this.activeroleinfo.equals(_o_.activeroleinfo)) return false;
/* 53 */       if (this.activeteamnum != _o_.activeteamnum) return false;
/* 54 */       if (!this.passiveroleinfo.equals(_o_.passiveroleinfo)) return false;
/* 55 */       if (this.passiveteamnum != _o_.passiveteamnum) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += this.activeroleinfo.hashCode();
/* 64 */     _h_ += this.activeteamnum;
/* 65 */     _h_ += this.passiveroleinfo.hashCode();
/* 66 */     _h_ += this.passiveteamnum;
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.activeroleinfo).append(",");
/* 74 */     _sb_.append(this.activeteamnum).append(",");
/* 75 */     _sb_.append(this.passiveroleinfo).append(",");
/* 76 */     _sb_.append(this.passiveteamnum).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\leitai\LeiTaiFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */