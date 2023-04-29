/*    */ package mzm.gsp.planttree;
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
/*    */ public class SGetRelatedRolePlantTreeSpecialStateSuccess
/*    */   extends __SGetRelatedRolePlantTreeSpecialStateSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12611606;
/*    */   public int activity_cfg_id;
/*    */   public HashMap<Long, Integer> special_states;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12611606;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetRelatedRolePlantTreeSpecialStateSuccess()
/*    */   {
/* 34 */     this.special_states = new HashMap();
/*    */   }
/*    */   
/*    */   public SGetRelatedRolePlantTreeSpecialStateSuccess(int _activity_cfg_id_, HashMap<Long, Integer> _special_states_) {
/* 38 */     this.activity_cfg_id = _activity_cfg_id_;
/* 39 */     this.special_states = _special_states_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.activity_cfg_id);
/* 48 */     _os_.compact_uint32(this.special_states.size());
/* 49 */     for (Map.Entry<Long, Integer> _e_ : this.special_states.entrySet()) {
/* 50 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 51 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 58 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 60 */       long _k_ = _os_.unmarshal_long();
/*    */       
/* 62 */       int _v_ = _os_.unmarshal_int();
/* 63 */       this.special_states.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SGetRelatedRolePlantTreeSpecialStateSuccess)) {
/* 74 */       SGetRelatedRolePlantTreeSpecialStateSuccess _o_ = (SGetRelatedRolePlantTreeSpecialStateSuccess)_o1_;
/* 75 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 76 */       if (!this.special_states.equals(_o_.special_states)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.activity_cfg_id;
/* 85 */     _h_ += this.special_states.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.activity_cfg_id).append(",");
/* 93 */     _sb_.append(this.special_states).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\SGetRelatedRolePlantTreeSpecialStateSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */