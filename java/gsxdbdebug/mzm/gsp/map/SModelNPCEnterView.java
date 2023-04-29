/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SModelNPCEnterView
/*    */   extends __SModelNPCEnterView__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590900;
/*    */   public int npcid;
/*    */   public Octets modelinfo;
/*    */   public EnterPosition posinit;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590900;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SModelNPCEnterView()
/*    */   {
/* 35 */     this.modelinfo = new Octets();
/* 36 */     this.posinit = new EnterPosition();
/*    */   }
/*    */   
/*    */   public SModelNPCEnterView(int _npcid_, Octets _modelinfo_, EnterPosition _posinit_) {
/* 40 */     this.npcid = _npcid_;
/* 41 */     this.modelinfo = _modelinfo_;
/* 42 */     this.posinit = _posinit_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     if (!this.posinit._validator_()) return false;
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.npcid);
/* 52 */     _os_.marshal(this.modelinfo);
/* 53 */     _os_.marshal(this.posinit);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.npcid = _os_.unmarshal_int();
/* 59 */     this.modelinfo = _os_.unmarshal_Octets();
/* 60 */     this.posinit.unmarshal(_os_);
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SModelNPCEnterView)) {
/* 70 */       SModelNPCEnterView _o_ = (SModelNPCEnterView)_o1_;
/* 71 */       if (this.npcid != _o_.npcid) return false;
/* 72 */       if (!this.modelinfo.equals(_o_.modelinfo)) return false;
/* 73 */       if (!this.posinit.equals(_o_.posinit)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.npcid;
/* 82 */     _h_ += this.modelinfo.hashCode();
/* 83 */     _h_ += this.posinit.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.npcid).append(",");
/* 91 */     _sb_.append("B").append(this.modelinfo.size()).append(",");
/* 92 */     _sb_.append(this.posinit).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SModelNPCEnterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */