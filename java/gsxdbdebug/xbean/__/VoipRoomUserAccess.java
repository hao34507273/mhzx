/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.LinkedList;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.Logs;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class VoipRoomUserAccess extends XBean implements xbean.VoipRoomUserAccess
/*     */ {
/*     */   private int role_state;
/*     */   private Octets open_id;
/*     */   private int member_id;
/*     */   private long room_key;
/*     */   private long extra_data;
/*     */   private LinkedList<Octets> access_ip_list;
/*     */   private int try_exit_times;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  30 */     this.role_state = 6;
/*  31 */     this.open_id = null;
/*  32 */     this.member_id = 0;
/*  33 */     this.room_key = 0L;
/*  34 */     this.extra_data = 0L;
/*  35 */     this.access_ip_list.clear();
/*  36 */     this.try_exit_times = 0;
/*     */   }
/*     */   
/*     */   VoipRoomUserAccess(int __, XBean _xp_, String _vn_)
/*     */   {
/*  41 */     super(_xp_, _vn_);
/*  42 */     this.role_state = 6;
/*  43 */     this.open_id = null;
/*  44 */     this.member_id = 0;
/*  45 */     this.room_key = 0L;
/*  46 */     this.extra_data = 0L;
/*  47 */     this.access_ip_list = new LinkedList();
/*  48 */     this.try_exit_times = 0;
/*     */   }
/*     */   
/*     */   public VoipRoomUserAccess()
/*     */   {
/*  53 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public VoipRoomUserAccess(VoipRoomUserAccess _o_)
/*     */   {
/*  58 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   VoipRoomUserAccess(xbean.VoipRoomUserAccess _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  63 */     super(_xp_, _vn_);
/*  64 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  76 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  82 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  88 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  94 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.VoipRoomUserAccess copy()
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/* 101 */     return new VoipRoomUserAccess(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.VoipRoomUserAccess toData()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.VoipRoomUserAccess toBean()
/*     */   {
/* 113 */     _xdb_verify_unsafe_();
/* 114 */     return new VoipRoomUserAccess(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.VoipRoomUserAccess toDataIf()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.VoipRoomUserAccess toBeanIf()
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/* 127 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 133 */     _xdb_verify_unsafe_();
/* 134 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRole_state()
/*     */   {
/* 141 */     _xdb_verify_unsafe_();
/* 142 */     return this.role_state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getOpen_id()
/*     */   {
/* 149 */     _xdb_verify_unsafe_();
/* 150 */     return this.open_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMember_id()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return this.member_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoom_key()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return this.room_key;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getExtra_data()
/*     */   {
/* 173 */     _xdb_verify_unsafe_();
/* 174 */     return this.extra_data;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.List<Octets> getAccess_ip_list()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return Logs.logList(new LogKey(this, "access_ip_list"), this.access_ip_list);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTry_exit_times()
/*     */   {
/* 189 */     _xdb_verify_unsafe_();
/* 190 */     return this.try_exit_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRole_state(int _v_)
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     Logs.logIf(new LogKey(this, "role_state")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 202 */         new LogInt(this, VoipRoomUserAccess.this.role_state)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 206 */             VoipRoomUserAccess.this.role_state = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 210 */     });
/* 211 */     this.role_state = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOpen_id(Octets _v_)
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     Logs.logIf(new LogKey(this, "open_id")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 223 */         new xdb.logs.LogObject(this, VoipRoomUserAccess.this.open_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 227 */             VoipRoomUserAccess.this.open_id = ((Octets)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 231 */     });
/* 232 */     this.open_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMember_id(int _v_)
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     Logs.logIf(new LogKey(this, "member_id")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 244 */         new LogInt(this, VoipRoomUserAccess.this.member_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 248 */             VoipRoomUserAccess.this.member_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 252 */     });
/* 253 */     this.member_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoom_key(long _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     Logs.logIf(new LogKey(this, "room_key")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 265 */         new xdb.logs.LogLong(this, VoipRoomUserAccess.this.room_key)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             VoipRoomUserAccess.this.room_key = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.room_key = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExtra_data(long _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     Logs.logIf(new LogKey(this, "extra_data")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 286 */         new xdb.logs.LogLong(this, VoipRoomUserAccess.this.extra_data)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             VoipRoomUserAccess.this.extra_data = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.extra_data = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTry_exit_times(int _v_)
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     Logs.logIf(new LogKey(this, "try_exit_times")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 307 */         new LogInt(this, VoipRoomUserAccess.this.try_exit_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 311 */             VoipRoomUserAccess.this.try_exit_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 315 */     });
/* 316 */     this.try_exit_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     VoipRoomUserAccess _o_ = null;
/* 324 */     if ((_o1_ instanceof VoipRoomUserAccess)) { _o_ = (VoipRoomUserAccess)_o1_;
/* 325 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 326 */       return false;
/* 327 */     if (this.role_state != _o_.role_state) return false;
/* 328 */     if (((null == this.open_id) && (null != _o_.open_id)) || ((null != this.open_id) && (null == _o_.open_id)) || ((null != this.open_id) && (null != _o_.open_id) && (!this.open_id.equals(_o_.open_id)))) return false;
/* 329 */     if (this.member_id != _o_.member_id) return false;
/* 330 */     if (this.room_key != _o_.room_key) return false;
/* 331 */     if (this.extra_data != _o_.extra_data) return false;
/* 332 */     if (!this.access_ip_list.equals(_o_.access_ip_list)) return false;
/* 333 */     if (this.try_exit_times != _o_.try_exit_times) return false;
/* 334 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 340 */     _xdb_verify_unsafe_();
/* 341 */     int _h_ = 0;
/* 342 */     _h_ += this.role_state;
/* 343 */     _h_ += (this.open_id == null ? 0 : this.open_id.hashCode());
/* 344 */     _h_ += this.member_id;
/* 345 */     _h_ = (int)(_h_ + this.room_key);
/* 346 */     _h_ = (int)(_h_ + this.extra_data);
/* 347 */     _h_ += this.access_ip_list.hashCode();
/* 348 */     _h_ += this.try_exit_times;
/* 349 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 355 */     _xdb_verify_unsafe_();
/* 356 */     StringBuilder _sb_ = new StringBuilder();
/* 357 */     _sb_.append("(");
/* 358 */     _sb_.append(this.role_state);
/* 359 */     _sb_.append(",");
/* 360 */     _sb_.append(this.open_id);
/* 361 */     _sb_.append(",");
/* 362 */     _sb_.append(this.member_id);
/* 363 */     _sb_.append(",");
/* 364 */     _sb_.append(this.room_key);
/* 365 */     _sb_.append(",");
/* 366 */     _sb_.append(this.extra_data);
/* 367 */     _sb_.append(",");
/* 368 */     _sb_.append(this.access_ip_list);
/* 369 */     _sb_.append(",");
/* 370 */     _sb_.append(this.try_exit_times);
/* 371 */     _sb_.append(")");
/* 372 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 378 */     ListenableBean lb = new ListenableBean();
/* 379 */     lb.add(new ListenableChanged().setVarName("role_state"));
/* 380 */     lb.add(new ListenableChanged().setVarName("open_id"));
/* 381 */     lb.add(new ListenableChanged().setVarName("member_id"));
/* 382 */     lb.add(new ListenableChanged().setVarName("room_key"));
/* 383 */     lb.add(new ListenableChanged().setVarName("extra_data"));
/* 384 */     lb.add(new ListenableChanged().setVarName("access_ip_list"));
/* 385 */     lb.add(new ListenableChanged().setVarName("try_exit_times"));
/* 386 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.VoipRoomUserAccess {
/*     */     private Const() {}
/*     */     
/*     */     VoipRoomUserAccess nThis() {
/* 393 */       return VoipRoomUserAccess.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 399 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoipRoomUserAccess copy()
/*     */     {
/* 405 */       return VoipRoomUserAccess.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoipRoomUserAccess toData()
/*     */     {
/* 411 */       return VoipRoomUserAccess.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.VoipRoomUserAccess toBean()
/*     */     {
/* 416 */       return VoipRoomUserAccess.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoipRoomUserAccess toDataIf()
/*     */     {
/* 422 */       return VoipRoomUserAccess.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.VoipRoomUserAccess toBeanIf()
/*     */     {
/* 427 */       return VoipRoomUserAccess.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRole_state()
/*     */     {
/* 434 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 435 */       return VoipRoomUserAccess.this.role_state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getOpen_id()
/*     */     {
/* 442 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 443 */       return VoipRoomUserAccess.this.open_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMember_id()
/*     */     {
/* 450 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 451 */       return VoipRoomUserAccess.this.member_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoom_key()
/*     */     {
/* 458 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 459 */       return VoipRoomUserAccess.this.room_key;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getExtra_data()
/*     */     {
/* 466 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 467 */       return VoipRoomUserAccess.this.extra_data;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<Octets> getAccess_ip_list()
/*     */     {
/* 474 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 475 */       return xdb.Consts.constList(VoipRoomUserAccess.this.access_ip_list);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTry_exit_times()
/*     */     {
/* 482 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 483 */       return VoipRoomUserAccess.this.try_exit_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_state(int _v_)
/*     */     {
/* 490 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 491 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOpen_id(Octets _v_)
/*     */     {
/* 498 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 499 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMember_id(int _v_)
/*     */     {
/* 506 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 507 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoom_key(long _v_)
/*     */     {
/* 514 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 515 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExtra_data(long _v_)
/*     */     {
/* 522 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 523 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTry_exit_times(int _v_)
/*     */     {
/* 530 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 531 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 537 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 538 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 544 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 545 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 551 */       return VoipRoomUserAccess.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 557 */       return VoipRoomUserAccess.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 563 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 564 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 570 */       return VoipRoomUserAccess.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 576 */       return VoipRoomUserAccess.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 582 */       VoipRoomUserAccess.this._xdb_verify_unsafe_();
/* 583 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 589 */       return VoipRoomUserAccess.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 595 */       return VoipRoomUserAccess.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 601 */       return VoipRoomUserAccess.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 607 */       return VoipRoomUserAccess.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 613 */       return VoipRoomUserAccess.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 619 */       return VoipRoomUserAccess.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 625 */       return VoipRoomUserAccess.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.VoipRoomUserAccess
/*     */   {
/*     */     private int role_state;
/*     */     
/*     */     private Octets open_id;
/*     */     
/*     */     private int member_id;
/*     */     
/*     */     private long room_key;
/*     */     
/*     */     private long extra_data;
/*     */     
/*     */     private LinkedList<Octets> access_ip_list;
/*     */     
/*     */     private int try_exit_times;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 649 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 654 */       this.role_state = 6;
/* 655 */       this.open_id = null;
/* 656 */       this.member_id = 0;
/* 657 */       this.room_key = 0L;
/* 658 */       this.extra_data = 0L;
/* 659 */       this.access_ip_list = new LinkedList();
/* 660 */       this.try_exit_times = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.VoipRoomUserAccess _o1_)
/*     */     {
/* 665 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 671 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 677 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 683 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 689 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 695 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoipRoomUserAccess copy()
/*     */     {
/* 701 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoipRoomUserAccess toData()
/*     */     {
/* 707 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.VoipRoomUserAccess toBean()
/*     */     {
/* 712 */       return new VoipRoomUserAccess(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoipRoomUserAccess toDataIf()
/*     */     {
/* 718 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.VoipRoomUserAccess toBeanIf()
/*     */     {
/* 723 */       return new VoipRoomUserAccess(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 729 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 733 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 737 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 741 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 745 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 749 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 753 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRole_state()
/*     */     {
/* 760 */       return this.role_state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getOpen_id()
/*     */     {
/* 767 */       return this.open_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMember_id()
/*     */     {
/* 774 */       return this.member_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoom_key()
/*     */     {
/* 781 */       return this.room_key;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getExtra_data()
/*     */     {
/* 788 */       return this.extra_data;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<Octets> getAccess_ip_list()
/*     */     {
/* 795 */       return this.access_ip_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTry_exit_times()
/*     */     {
/* 802 */       return this.try_exit_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_state(int _v_)
/*     */     {
/* 809 */       this.role_state = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOpen_id(Octets _v_)
/*     */     {
/* 816 */       this.open_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMember_id(int _v_)
/*     */     {
/* 823 */       this.member_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoom_key(long _v_)
/*     */     {
/* 830 */       this.room_key = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExtra_data(long _v_)
/*     */     {
/* 837 */       this.extra_data = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTry_exit_times(int _v_)
/*     */     {
/* 844 */       this.try_exit_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 850 */       if (!(_o1_ instanceof Data)) return false;
/* 851 */       Data _o_ = (Data)_o1_;
/* 852 */       if (this.role_state != _o_.role_state) return false;
/* 853 */       if (((null == this.open_id) && (null != _o_.open_id)) || ((null != this.open_id) && (null == _o_.open_id)) || ((null != this.open_id) && (null != _o_.open_id) && (!this.open_id.equals(_o_.open_id)))) return false;
/* 854 */       if (this.member_id != _o_.member_id) return false;
/* 855 */       if (this.room_key != _o_.room_key) return false;
/* 856 */       if (this.extra_data != _o_.extra_data) return false;
/* 857 */       if (!this.access_ip_list.equals(_o_.access_ip_list)) return false;
/* 858 */       if (this.try_exit_times != _o_.try_exit_times) return false;
/* 859 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 865 */       int _h_ = 0;
/* 866 */       _h_ += this.role_state;
/* 867 */       _h_ += (this.open_id == null ? 0 : this.open_id.hashCode());
/* 868 */       _h_ += this.member_id;
/* 869 */       _h_ = (int)(_h_ + this.room_key);
/* 870 */       _h_ = (int)(_h_ + this.extra_data);
/* 871 */       _h_ += this.access_ip_list.hashCode();
/* 872 */       _h_ += this.try_exit_times;
/* 873 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 879 */       StringBuilder _sb_ = new StringBuilder();
/* 880 */       _sb_.append("(");
/* 881 */       _sb_.append(this.role_state);
/* 882 */       _sb_.append(",");
/* 883 */       _sb_.append(this.open_id);
/* 884 */       _sb_.append(",");
/* 885 */       _sb_.append(this.member_id);
/* 886 */       _sb_.append(",");
/* 887 */       _sb_.append(this.room_key);
/* 888 */       _sb_.append(",");
/* 889 */       _sb_.append(this.extra_data);
/* 890 */       _sb_.append(",");
/* 891 */       _sb_.append(this.access_ip_list);
/* 892 */       _sb_.append(",");
/* 893 */       _sb_.append(this.try_exit_times);
/* 894 */       _sb_.append(")");
/* 895 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\VoipRoomUserAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */