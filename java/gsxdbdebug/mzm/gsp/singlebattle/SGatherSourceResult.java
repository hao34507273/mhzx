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
/*    */ public class SGatherSourceResult
/*    */   extends __SGatherSourceResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12621592;
/*    */   public HashMap<Long, Integer> role2totalsource;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12621592;
/*    */   }
/*    */   
/*    */ 
/*    */   public SGatherSourceResult()
/*    */   {
/* 33 */     this.role2totalsource = new HashMap();
/*    */   }
/*    */   
/*    */   public SGatherSourceResult(HashMap<Long, Integer> _role2totalsource_) {
/* 37 */     this.role2totalsource = _role2totalsource_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.role2totalsource.size());
/* 46 */     for (Map.Entry<Long, Integer> _e_ : this.role2totalsource.entrySet()) {
/* 47 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 48 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 56 */       long _k_ = _os_.unmarshal_long();
/*    */       
/* 58 */       int _v_ = _os_.unmarshal_int();
/* 59 */       this.role2totalsource.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SGatherSourceResult)) {
/* 70 */       SGatherSourceResult _o_ = (SGatherSourceResult)_o1_;
/* 71 */       if (!this.role2totalsource.equals(_o_.role2totalsource)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.role2totalsource.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.role2totalsource).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\SGatherSourceResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */