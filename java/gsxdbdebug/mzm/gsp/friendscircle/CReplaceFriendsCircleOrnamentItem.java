/*    */ package mzm.gsp.friendscircle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.friendscircle.main.PCReplaceFriendsCircleOrnamentItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CReplaceFriendsCircleOrnamentItem
/*    */   extends __CReplaceFriendsCircleOrnamentItem__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12625420;
/*    */   public HashMap<Integer, Integer> replace_ornament_map;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PCReplaceFriendsCircleOrnamentItem(roleId, this.replace_ornament_map));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12625420;
/*    */   }
/*    */   
/*    */ 
/*    */   public CReplaceFriendsCircleOrnamentItem()
/*    */   {
/* 39 */     this.replace_ornament_map = new HashMap();
/*    */   }
/*    */   
/*    */   public CReplaceFriendsCircleOrnamentItem(HashMap<Integer, Integer> _replace_ornament_map_) {
/* 43 */     this.replace_ornament_map = _replace_ornament_map_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.compact_uint32(this.replace_ornament_map.size());
/* 52 */     for (Map.Entry<Integer, Integer> _e_ : this.replace_ornament_map.entrySet()) {
/* 53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 54 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 62 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 64 */       int _v_ = _os_.unmarshal_int();
/* 65 */       this.replace_ornament_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 67 */     if (!_validator_()) {
/* 68 */       throw new VerifyError("validator failed");
/*    */     }
/* 70 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 74 */     if (_o1_ == this) return true;
/* 75 */     if ((_o1_ instanceof CReplaceFriendsCircleOrnamentItem)) {
/* 76 */       CReplaceFriendsCircleOrnamentItem _o_ = (CReplaceFriendsCircleOrnamentItem)_o1_;
/* 77 */       if (!this.replace_ornament_map.equals(_o_.replace_ornament_map)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.replace_ornament_map.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.replace_ornament_map).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\CReplaceFriendsCircleOrnamentItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */