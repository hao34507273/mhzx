/*    */ package mzm.gsp.task;
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
/*    */ public class SSyncSurpriseServerLevel
/*    */   extends __SSyncSurpriseServerLevel__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592160;
/*    */   public HashMap<Integer, Long> level2starttime;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12592160;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncSurpriseServerLevel()
/*    */   {
/* 33 */     this.level2starttime = new HashMap();
/*    */   }
/*    */   
/*    */   public SSyncSurpriseServerLevel(HashMap<Integer, Long> _level2starttime_) {
/* 37 */     this.level2starttime = _level2starttime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.level2starttime.size());
/* 46 */     for (Map.Entry<Integer, Long> _e_ : this.level2starttime.entrySet()) {
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
/* 59 */       this.level2starttime.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*    */     }
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SSyncSurpriseServerLevel)) {
/* 70 */       SSyncSurpriseServerLevel _o_ = (SSyncSurpriseServerLevel)_o1_;
/* 71 */       if (!this.level2starttime.equals(_o_.level2starttime)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.level2starttime.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.level2starttime).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\SSyncSurpriseServerLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */