/*    */ package mzm.gsp.interaction;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
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
/*    */ public class SGetInteractionTargetList
/*    */   extends __SGetInteractionTargetList__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12622599;
/*    */   public int interaction_id;
/*    */   public ArrayList<RoleListItem> target_list;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12622599;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetInteractionTargetList()
/*    */   {
/* 34 */     this.target_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public SGetInteractionTargetList(int _interaction_id_, ArrayList<RoleListItem> _target_list_) {
/* 38 */     this.interaction_id = _interaction_id_;
/* 39 */     this.target_list = _target_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (RoleListItem _v_ : this.target_list)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.interaction_id);
/* 50 */     _os_.compact_uint32(this.target_list.size());
/* 51 */     for (RoleListItem _v_ : this.target_list) {
/* 52 */       _os_.marshal(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.interaction_id = _os_.unmarshal_int();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       RoleListItem _v_ = new RoleListItem();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.target_list.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SGetInteractionTargetList)) {
/* 73 */       SGetInteractionTargetList _o_ = (SGetInteractionTargetList)_o1_;
/* 74 */       if (this.interaction_id != _o_.interaction_id) return false;
/* 75 */       if (!this.target_list.equals(_o_.target_list)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.interaction_id;
/* 84 */     _h_ += this.target_list.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.interaction_id).append(",");
/* 92 */     _sb_.append(this.target_list).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\SGetInteractionTargetList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */