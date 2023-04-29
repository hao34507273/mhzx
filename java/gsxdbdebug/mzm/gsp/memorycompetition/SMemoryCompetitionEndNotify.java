/*    */ package mzm.gsp.memorycompetition;
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
/*    */ public class SMemoryCompetitionEndNotify
/*    */   extends __SMemoryCompetitionEndNotify__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12613129;
/*    */   public int activity_cfg_id;
/*    */   public HashMap<Long, QuestionIdList> roles_answer_map;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12613129;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMemoryCompetitionEndNotify()
/*    */   {
/* 34 */     this.roles_answer_map = new HashMap();
/*    */   }
/*    */   
/*    */   public SMemoryCompetitionEndNotify(int _activity_cfg_id_, HashMap<Long, QuestionIdList> _roles_answer_map_) {
/* 38 */     this.activity_cfg_id = _activity_cfg_id_;
/* 39 */     this.roles_answer_map = _roles_answer_map_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (Map.Entry<Long, QuestionIdList> _e_ : this.roles_answer_map.entrySet()) {
/* 44 */       if (!((QuestionIdList)_e_.getValue())._validator_()) return false;
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.activity_cfg_id);
/* 51 */     _os_.compact_uint32(this.roles_answer_map.size());
/* 52 */     for (Map.Entry<Long, QuestionIdList> _e_ : this.roles_answer_map.entrySet()) {
/* 53 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 54 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 61 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 63 */       long _k_ = _os_.unmarshal_long();
/* 64 */       QuestionIdList _v_ = new QuestionIdList();
/* 65 */       _v_.unmarshal(_os_);
/* 66 */       this.roles_answer_map.put(Long.valueOf(_k_), _v_);
/*    */     }
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof SMemoryCompetitionEndNotify)) {
/* 77 */       SMemoryCompetitionEndNotify _o_ = (SMemoryCompetitionEndNotify)_o1_;
/* 78 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 79 */       if (!this.roles_answer_map.equals(_o_.roles_answer_map)) return false;
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 86 */     int _h_ = 0;
/* 87 */     _h_ += this.activity_cfg_id;
/* 88 */     _h_ += this.roles_answer_map.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.activity_cfg_id).append(",");
/* 96 */     _sb_.append(this.roles_answer_map).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\SMemoryCompetitionEndNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */