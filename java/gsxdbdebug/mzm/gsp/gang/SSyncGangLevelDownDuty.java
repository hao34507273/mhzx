/*    */ package mzm.gsp.gang;
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
/*    */ 
/*    */ public class SSyncGangLevelDownDuty
/*    */   extends __SSyncGangLevelDownDuty__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589843;
/*    */   public HashMap<Integer, Integer> building2level;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 28 */     return 12589843;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncGangLevelDownDuty()
/*    */   {
/* 34 */     this.building2level = new HashMap();
/*    */   }
/*    */   
/*    */   public SSyncGangLevelDownDuty(HashMap<Integer, Integer> _building2level_) {
/* 38 */     this.building2level = _building2level_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.compact_uint32(this.building2level.size());
/* 47 */     for (Map.Entry<Integer, Integer> _e_ : this.building2level.entrySet()) {
/* 48 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 49 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 57 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 59 */       int _v_ = _os_.unmarshal_int();
/* 60 */       this.building2level.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SSyncGangLevelDownDuty)) {
/* 71 */       SSyncGangLevelDownDuty _o_ = (SSyncGangLevelDownDuty)_o1_;
/* 72 */       if (!this.building2level.equals(_o_.building2level)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.building2level.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.building2level).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncGangLevelDownDuty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */