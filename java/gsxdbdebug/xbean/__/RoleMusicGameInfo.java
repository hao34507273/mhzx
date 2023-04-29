/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xbean.MusicGameInfo;
/*     */ import xdb.Bean;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class RoleMusicGameInfo extends XBean implements xbean.RoleMusicGameInfo
/*     */ {
/*     */   private HashMap<Integer, MusicGameInfo> music_game_infos;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.music_game_infos.clear();
/*     */   }
/*     */   
/*     */   RoleMusicGameInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.music_game_infos = new HashMap();
/*     */   }
/*     */   
/*     */   public RoleMusicGameInfo()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleMusicGameInfo(RoleMusicGameInfo _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleMusicGameInfo(xbean.RoleMusicGameInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  46 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  52 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  58 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  64 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  70 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleMusicGameInfo copy()
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     return new RoleMusicGameInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleMusicGameInfo toData()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleMusicGameInfo toBean()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     return new RoleMusicGameInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleMusicGameInfo toDataIf()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleMusicGameInfo toBeanIf()
/*     */   {
/* 102 */     _xdb_verify_unsafe_();
/* 103 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/* 110 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Integer, MusicGameInfo> getMusic_game_infos()
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/* 118 */     return xdb.Logs.logMap(new xdb.LogKey(this, "music_game_infos"), this.music_game_infos);
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 124 */     _xdb_verify_unsafe_();
/* 125 */     RoleMusicGameInfo _o_ = null;
/* 126 */     if ((_o1_ instanceof RoleMusicGameInfo)) { _o_ = (RoleMusicGameInfo)_o1_;
/* 127 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 128 */       return false;
/* 129 */     if (!this.music_game_infos.equals(_o_.music_game_infos)) return false;
/* 130 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 136 */     _xdb_verify_unsafe_();
/* 137 */     int _h_ = 0;
/* 138 */     _h_ += this.music_game_infos.hashCode();
/* 139 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 145 */     _xdb_verify_unsafe_();
/* 146 */     StringBuilder _sb_ = new StringBuilder();
/* 147 */     _sb_.append("(");
/* 148 */     _sb_.append(this.music_game_infos);
/* 149 */     _sb_.append(")");
/* 150 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 156 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 157 */     lb.add(new xdb.logs.ListenableMap().setVarName("music_game_infos"));
/* 158 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleMusicGameInfo {
/*     */     private Const() {}
/*     */     
/*     */     RoleMusicGameInfo nThis() {
/* 165 */       return RoleMusicGameInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 171 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleMusicGameInfo copy()
/*     */     {
/* 177 */       return RoleMusicGameInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleMusicGameInfo toData()
/*     */     {
/* 183 */       return RoleMusicGameInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleMusicGameInfo toBean()
/*     */     {
/* 188 */       return RoleMusicGameInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleMusicGameInfo toDataIf()
/*     */     {
/* 194 */       return RoleMusicGameInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleMusicGameInfo toBeanIf()
/*     */     {
/* 199 */       return RoleMusicGameInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, MusicGameInfo> getMusic_game_infos()
/*     */     {
/* 206 */       RoleMusicGameInfo.this._xdb_verify_unsafe_();
/* 207 */       return xdb.Consts.constMap(RoleMusicGameInfo.this.music_game_infos);
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 213 */       RoleMusicGameInfo.this._xdb_verify_unsafe_();
/* 214 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 220 */       RoleMusicGameInfo.this._xdb_verify_unsafe_();
/* 221 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 227 */       return RoleMusicGameInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 233 */       return RoleMusicGameInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 239 */       RoleMusicGameInfo.this._xdb_verify_unsafe_();
/* 240 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 246 */       return RoleMusicGameInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 252 */       return RoleMusicGameInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 258 */       RoleMusicGameInfo.this._xdb_verify_unsafe_();
/* 259 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 265 */       return RoleMusicGameInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 271 */       return RoleMusicGameInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 277 */       return RoleMusicGameInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 283 */       return RoleMusicGameInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 289 */       return RoleMusicGameInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 295 */       return RoleMusicGameInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 301 */       return RoleMusicGameInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleMusicGameInfo
/*     */   {
/*     */     private HashMap<Integer, MusicGameInfo> music_game_infos;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 313 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 318 */       this.music_game_infos = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.RoleMusicGameInfo _o1_)
/*     */     {
/* 323 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 329 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 335 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 347 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 353 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleMusicGameInfo copy()
/*     */     {
/* 359 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleMusicGameInfo toData()
/*     */     {
/* 365 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleMusicGameInfo toBean()
/*     */     {
/* 370 */       return new RoleMusicGameInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleMusicGameInfo toDataIf()
/*     */     {
/* 376 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleMusicGameInfo toBeanIf()
/*     */     {
/* 381 */       return new RoleMusicGameInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 387 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 391 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 395 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 399 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 407 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 411 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, MusicGameInfo> getMusic_game_infos()
/*     */     {
/* 418 */       return this.music_game_infos;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 424 */       if (!(_o1_ instanceof Data)) return false;
/* 425 */       Data _o_ = (Data)_o1_;
/* 426 */       if (!this.music_game_infos.equals(_o_.music_game_infos)) return false;
/* 427 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 433 */       int _h_ = 0;
/* 434 */       _h_ += this.music_game_infos.hashCode();
/* 435 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 441 */       StringBuilder _sb_ = new StringBuilder();
/* 442 */       _sb_.append("(");
/* 443 */       _sb_.append(this.music_game_infos);
/* 444 */       _sb_.append(")");
/* 445 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleMusicGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */