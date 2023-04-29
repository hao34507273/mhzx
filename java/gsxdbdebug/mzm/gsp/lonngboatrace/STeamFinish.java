/*    */ package mzm.gsp.lonngboatrace;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
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
/*    */ public class STeamFinish
/*    */   extends __STeamFinish__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619274;
/*    */   public HashMap<Long, Statistic> role2statistic;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12619274;
/*    */   }
/*    */   
/*    */ 
/*    */   public STeamFinish()
/*    */   {
/* 33 */     this.role2statistic = new HashMap();
/*    */   }
/*    */   
/*    */   public STeamFinish(HashMap<Long, Statistic> _role2statistic_) {
/* 37 */     this.role2statistic = _role2statistic_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (Map.Entry<Long, Statistic> _e_ : this.role2statistic.entrySet()) {
/* 42 */       if (!((Statistic)_e_.getValue())._validator_()) return false;
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.compact_uint32(this.role2statistic.size());
/* 49 */     for (Map.Entry<Long, Statistic> _e_ : this.role2statistic.entrySet()) {
/* 50 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 51 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 59 */       long _k_ = _os_.unmarshal_long();
/* 60 */       Statistic _v_ = new Statistic();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.role2statistic.put(Long.valueOf(_k_), _v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof STeamFinish)) {
/* 73 */       STeamFinish _o_ = (STeamFinish)_o1_;
/* 74 */       if (!this.role2statistic.equals(_o_.role2statistic)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.role2statistic.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.role2statistic).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\STeamFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */