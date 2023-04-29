/*    */ package mzm.gsp.apollo;
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
/*    */ public class SSynVoipRoomOnlineMembers
/*    */   extends __SSynVoipRoomOnlineMembers__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602641;
/*    */   public int voip_room_type;
/*    */   public ArrayList<Long> online_member_list;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12602641;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynVoipRoomOnlineMembers()
/*    */   {
/* 34 */     this.online_member_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynVoipRoomOnlineMembers(int _voip_room_type_, ArrayList<Long> _online_member_list_) {
/* 38 */     this.voip_room_type = _voip_room_type_;
/* 39 */     this.online_member_list = _online_member_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.voip_room_type);
/* 48 */     _os_.compact_uint32(this.online_member_list.size());
/* 49 */     for (Long _v_ : this.online_member_list) {
/* 50 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.voip_room_type = _os_.unmarshal_int();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 59 */       long _v_ = _os_.unmarshal_long();
/* 60 */       this.online_member_list.add(Long.valueOf(_v_));
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SSynVoipRoomOnlineMembers)) {
/* 71 */       SSynVoipRoomOnlineMembers _o_ = (SSynVoipRoomOnlineMembers)_o1_;
/* 72 */       if (this.voip_room_type != _o_.voip_room_type) return false;
/* 73 */       if (!this.online_member_list.equals(_o_.online_member_list)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.voip_room_type;
/* 82 */     _h_ += this.online_member_list.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.voip_room_type).append(",");
/* 90 */     _sb_.append(this.online_member_list).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\SSynVoipRoomOnlineMembers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */