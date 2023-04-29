/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chat.main.PChangeChannelInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChangeChannelInfo
/*    */   extends __CChangeChannelInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585223;
/*    */   public HashMap<Integer, Integer> chatcfginfo;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PChangeChannelInfo(roleId, this.chatcfginfo));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12585223;
/*    */   }
/*    */   
/*    */ 
/*    */   public CChangeChannelInfo()
/*    */   {
/* 38 */     this.chatcfginfo = new HashMap();
/*    */   }
/*    */   
/*    */   public CChangeChannelInfo(HashMap<Integer, Integer> _chatcfginfo_) {
/* 42 */     this.chatcfginfo = _chatcfginfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.compact_uint32(this.chatcfginfo.size());
/* 51 */     for (Map.Entry<Integer, Integer> _e_ : this.chatcfginfo.entrySet()) {
/* 52 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 53 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 61 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.chatcfginfo.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof CChangeChannelInfo)) {
/* 75 */       CChangeChannelInfo _o_ = (CChangeChannelInfo)_o1_;
/* 76 */       if (!this.chatcfginfo.equals(_o_.chatcfginfo)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.chatcfginfo.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.chatcfginfo).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CChangeChannelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */