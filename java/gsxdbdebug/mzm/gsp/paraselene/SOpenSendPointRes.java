/*    */ package mzm.gsp.paraselene;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SOpenSendPointRes
/*    */   extends __SOpenSendPointRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598275;
/*    */   public int npc;
/*    */   public int npcservice;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12598275;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SOpenSendPointRes() {}
/*    */   
/*    */ 
/*    */   public SOpenSendPointRes(int _npc_, int _npcservice_)
/*    */   {
/* 37 */     this.npc = _npc_;
/* 38 */     this.npcservice = _npcservice_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.npc);
/* 47 */     _os_.marshal(this.npcservice);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.npc = _os_.unmarshal_int();
/* 53 */     this.npcservice = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SOpenSendPointRes)) {
/* 63 */       SOpenSendPointRes _o_ = (SOpenSendPointRes)_o1_;
/* 64 */       if (this.npc != _o_.npc) return false;
/* 65 */       if (this.npcservice != _o_.npcservice) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.npc;
/* 74 */     _h_ += this.npcservice;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.npc).append(",");
/* 82 */     _sb_.append(this.npcservice).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SOpenSendPointRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.npc - _o_.npc;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.npcservice - _o_.npcservice;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\SOpenSendPointRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */