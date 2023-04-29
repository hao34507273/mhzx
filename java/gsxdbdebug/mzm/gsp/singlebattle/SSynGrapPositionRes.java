/*    */ package mzm.gsp.singlebattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
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
/*    */ public class SSynGrapPositionRes
/*    */   extends __SSynGrapPositionRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12621584;
/*    */   public HashMap<Integer, Long> position2firstblood;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12621584;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynGrapPositionRes()
/*    */   {
/* 33 */     this.position2firstblood = new HashMap();
/*    */   }
/*    */   
/*    */   public SSynGrapPositionRes(HashMap<Integer, Long> _position2firstblood_) {
/* 37 */     this.position2firstblood = _position2firstblood_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.position2firstblood.size());
/* 46 */     for (Map.Entry<Integer, Long> _e_ : this.position2firstblood.entrySet()) {
/* 47 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 48 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 56 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 58 */       long _v_ = _os_.unmarshal_long();
/* 59 */       this.position2firstblood.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*    */     }
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SSynGrapPositionRes)) {
/* 70 */       SSynGrapPositionRes _o_ = (SSynGrapPositionRes)_o1_;
/* 71 */       if (!this.position2firstblood.equals(_o_.position2firstblood)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.position2firstblood.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.position2firstblood).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\SSynGrapPositionRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */