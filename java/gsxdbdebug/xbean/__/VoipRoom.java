/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.Logs;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class VoipRoom extends XBean implements xbean.VoipRoom
/*     */ {
/*     */   private int room_state;
/*     */   private long room_id;
/*     */   private HashMap<Long, xbean.VoipRoomUserAccess> members;
/*     */   private ArrayList<Long> pending_list;
/*     */   private long creater_id;
/*     */   private long close_sessionid;
/*     */   private int try_close_times;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  30 */     this.room_state = 5;
/*  31 */     this.room_id = -1L;
/*  32 */     this.members.clear();
/*  33 */     this.pending_list.clear();
/*  34 */     this.creater_id = -1L;
/*  35 */     this.close_sessionid = -1L;
/*  36 */     this.try_close_times = 0;
/*     */   }
/*     */   
/*     */   VoipRoom(int __, XBean _xp_, String _vn_)
/*     */   {
/*  41 */     super(_xp_, _vn_);
/*  42 */     this.room_state = 5;
/*  43 */     this.room_id = -1L;
/*  44 */     this.members = new HashMap();
/*  45 */     this.pending_list = new ArrayList();
/*  46 */     this.creater_id = -1L;
/*  47 */     this.close_sessionid = -1L;
/*  48 */     this.try_close_times = 0;
/*     */   }
/*     */   
/*     */   public VoipRoom()
/*     */   {
/*  53 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public VoipRoom(VoipRoom _o_)
/*     */   {
/*  58 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   VoipRoom(xbean.VoipRoom _o1_, XBean _xp_, String _vn_)
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
/*     */   public xbean.VoipRoom copy()
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/* 101 */     return new VoipRoom(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.VoipRoom toData()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.VoipRoom toBean()
/*     */   {
/* 113 */     _xdb_verify_unsafe_();
/* 114 */     return new VoipRoom(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.VoipRoom toDataIf()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.VoipRoom toBeanIf()
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/* 127 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 133 */     _xdb_verify_unsafe_();
/* 134 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRoom_state()
/*     */   {
/* 141 */     _xdb_verify_unsafe_();
/* 142 */     return this.room_state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoom_id()
/*     */   {
/* 149 */     _xdb_verify_unsafe_();
/* 150 */     return this.room_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Long, xbean.VoipRoomUserAccess> getMembers()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return Logs.logMap(new LogKey(this, "members"), this.members);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getPending_list()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return Logs.logList(new LogKey(this, "pending_list"), this.pending_list);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getPending_listAsData()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/*     */     
/* 174 */     VoipRoom _o_ = this;
/* 175 */     List<Long> pending_list = new ArrayList();
/* 176 */     pending_list.addAll(_o_.pending_list);
/* 177 */     return pending_list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getCreater_id()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return this.creater_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getClose_sessionid()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return this.close_sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTry_close_times()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this.try_close_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoom_state(int _v_)
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     Logs.logIf(new LogKey(this, "room_state")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 213 */         new xdb.logs.LogInt(this, VoipRoom.this.room_state)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 217 */             VoipRoom.this.room_state = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 221 */     });
/* 222 */     this.room_state = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoom_id(long _v_)
/*     */   {
/* 229 */     _xdb_verify_unsafe_();
/* 230 */     Logs.logIf(new LogKey(this, "room_id")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 234 */         new LogLong(this, VoipRoom.this.room_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 238 */             VoipRoom.this.room_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 242 */     });
/* 243 */     this.room_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreater_id(long _v_)
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     Logs.logIf(new LogKey(this, "creater_id")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 255 */         new LogLong(this, VoipRoom.this.creater_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 259 */             VoipRoom.this.creater_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 263 */     });
/* 264 */     this.creater_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setClose_sessionid(long _v_)
/*     */   {
/* 271 */     _xdb_verify_unsafe_();
/* 272 */     Logs.logIf(new LogKey(this, "close_sessionid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 276 */         new LogLong(this, VoipRoom.this.close_sessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 280 */             VoipRoom.this.close_sessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 284 */     });
/* 285 */     this.close_sessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTry_close_times(int _v_)
/*     */   {
/* 292 */     _xdb_verify_unsafe_();
/* 293 */     Logs.logIf(new LogKey(this, "try_close_times")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 297 */         new xdb.logs.LogInt(this, VoipRoom.this.try_close_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 301 */             VoipRoom.this.try_close_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 305 */     });
/* 306 */     this.try_close_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     VoipRoom _o_ = null;
/* 314 */     if ((_o1_ instanceof VoipRoom)) { _o_ = (VoipRoom)_o1_;
/* 315 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 316 */       return false;
/* 317 */     if (this.room_state != _o_.room_state) return false;
/* 318 */     if (this.room_id != _o_.room_id) return false;
/* 319 */     if (!this.members.equals(_o_.members)) return false;
/* 320 */     if (!this.pending_list.equals(_o_.pending_list)) return false;
/* 321 */     if (this.creater_id != _o_.creater_id) return false;
/* 322 */     if (this.close_sessionid != _o_.close_sessionid) return false;
/* 323 */     if (this.try_close_times != _o_.try_close_times) return false;
/* 324 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 330 */     _xdb_verify_unsafe_();
/* 331 */     int _h_ = 0;
/* 332 */     _h_ += this.room_state;
/* 333 */     _h_ = (int)(_h_ + this.room_id);
/* 334 */     _h_ += this.members.hashCode();
/* 335 */     _h_ += this.pending_list.hashCode();
/* 336 */     _h_ = (int)(_h_ + this.creater_id);
/* 337 */     _h_ = (int)(_h_ + this.close_sessionid);
/* 338 */     _h_ += this.try_close_times;
/* 339 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     StringBuilder _sb_ = new StringBuilder();
/* 347 */     _sb_.append("(");
/* 348 */     _sb_.append(this.room_state);
/* 349 */     _sb_.append(",");
/* 350 */     _sb_.append(this.room_id);
/* 351 */     _sb_.append(",");
/* 352 */     _sb_.append(this.members);
/* 353 */     _sb_.append(",");
/* 354 */     _sb_.append(this.pending_list);
/* 355 */     _sb_.append(",");
/* 356 */     _sb_.append(this.creater_id);
/* 357 */     _sb_.append(",");
/* 358 */     _sb_.append(this.close_sessionid);
/* 359 */     _sb_.append(",");
/* 360 */     _sb_.append(this.try_close_times);
/* 361 */     _sb_.append(")");
/* 362 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 368 */     ListenableBean lb = new ListenableBean();
/* 369 */     lb.add(new ListenableChanged().setVarName("room_state"));
/* 370 */     lb.add(new ListenableChanged().setVarName("room_id"));
/* 371 */     lb.add(new xdb.logs.ListenableMap().setVarName("members"));
/* 372 */     lb.add(new ListenableChanged().setVarName("pending_list"));
/* 373 */     lb.add(new ListenableChanged().setVarName("creater_id"));
/* 374 */     lb.add(new ListenableChanged().setVarName("close_sessionid"));
/* 375 */     lb.add(new ListenableChanged().setVarName("try_close_times"));
/* 376 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.VoipRoom {
/*     */     private Const() {}
/*     */     
/*     */     VoipRoom nThis() {
/* 383 */       return VoipRoom.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 389 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoipRoom copy()
/*     */     {
/* 395 */       return VoipRoom.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoipRoom toData()
/*     */     {
/* 401 */       return VoipRoom.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.VoipRoom toBean()
/*     */     {
/* 406 */       return VoipRoom.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoipRoom toDataIf()
/*     */     {
/* 412 */       return VoipRoom.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.VoipRoom toBeanIf()
/*     */     {
/* 417 */       return VoipRoom.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRoom_state()
/*     */     {
/* 424 */       VoipRoom.this._xdb_verify_unsafe_();
/* 425 */       return VoipRoom.this.room_state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoom_id()
/*     */     {
/* 432 */       VoipRoom.this._xdb_verify_unsafe_();
/* 433 */       return VoipRoom.this.room_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, xbean.VoipRoomUserAccess> getMembers()
/*     */     {
/* 440 */       VoipRoom.this._xdb_verify_unsafe_();
/* 441 */       return xdb.Consts.constMap(VoipRoom.this.members);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getPending_list()
/*     */     {
/* 448 */       VoipRoom.this._xdb_verify_unsafe_();
/* 449 */       return xdb.Consts.constList(VoipRoom.this.pending_list);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getPending_listAsData()
/*     */     {
/* 455 */       VoipRoom.this._xdb_verify_unsafe_();
/*     */       
/* 457 */       VoipRoom _o_ = VoipRoom.this;
/* 458 */       List<Long> pending_list = new ArrayList();
/* 459 */       pending_list.addAll(_o_.pending_list);
/* 460 */       return pending_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCreater_id()
/*     */     {
/* 467 */       VoipRoom.this._xdb_verify_unsafe_();
/* 468 */       return VoipRoom.this.creater_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getClose_sessionid()
/*     */     {
/* 475 */       VoipRoom.this._xdb_verify_unsafe_();
/* 476 */       return VoipRoom.this.close_sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTry_close_times()
/*     */     {
/* 483 */       VoipRoom.this._xdb_verify_unsafe_();
/* 484 */       return VoipRoom.this.try_close_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoom_state(int _v_)
/*     */     {
/* 491 */       VoipRoom.this._xdb_verify_unsafe_();
/* 492 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoom_id(long _v_)
/*     */     {
/* 499 */       VoipRoom.this._xdb_verify_unsafe_();
/* 500 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCreater_id(long _v_)
/*     */     {
/* 507 */       VoipRoom.this._xdb_verify_unsafe_();
/* 508 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setClose_sessionid(long _v_)
/*     */     {
/* 515 */       VoipRoom.this._xdb_verify_unsafe_();
/* 516 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTry_close_times(int _v_)
/*     */     {
/* 523 */       VoipRoom.this._xdb_verify_unsafe_();
/* 524 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 530 */       VoipRoom.this._xdb_verify_unsafe_();
/* 531 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 537 */       VoipRoom.this._xdb_verify_unsafe_();
/* 538 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 544 */       return VoipRoom.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 550 */       return VoipRoom.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 556 */       VoipRoom.this._xdb_verify_unsafe_();
/* 557 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 563 */       return VoipRoom.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 569 */       return VoipRoom.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 575 */       VoipRoom.this._xdb_verify_unsafe_();
/* 576 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 582 */       return VoipRoom.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 588 */       return VoipRoom.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 594 */       return VoipRoom.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 600 */       return VoipRoom.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 606 */       return VoipRoom.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 612 */       return VoipRoom.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 618 */       return VoipRoom.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.VoipRoom
/*     */   {
/*     */     private int room_state;
/*     */     
/*     */     private long room_id;
/*     */     
/*     */     private HashMap<Long, xbean.VoipRoomUserAccess> members;
/*     */     
/*     */     private ArrayList<Long> pending_list;
/*     */     
/*     */     private long creater_id;
/*     */     
/*     */     private long close_sessionid;
/*     */     
/*     */     private int try_close_times;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 642 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 647 */       this.room_state = 5;
/* 648 */       this.room_id = -1L;
/* 649 */       this.members = new HashMap();
/* 650 */       this.pending_list = new ArrayList();
/* 651 */       this.creater_id = -1L;
/* 652 */       this.close_sessionid = -1L;
/* 653 */       this.try_close_times = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.VoipRoom _o1_)
/*     */     {
/* 658 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 664 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 670 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 676 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 682 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 688 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoipRoom copy()
/*     */     {
/* 694 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoipRoom toData()
/*     */     {
/* 700 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.VoipRoom toBean()
/*     */     {
/* 705 */       return new VoipRoom(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoipRoom toDataIf()
/*     */     {
/* 711 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.VoipRoom toBeanIf()
/*     */     {
/* 716 */       return new VoipRoom(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 722 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 726 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 730 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 734 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 738 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 742 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 746 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRoom_state()
/*     */     {
/* 753 */       return this.room_state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoom_id()
/*     */     {
/* 760 */       return this.room_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, xbean.VoipRoomUserAccess> getMembers()
/*     */     {
/* 767 */       return this.members;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getPending_list()
/*     */     {
/* 774 */       return this.pending_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getPending_listAsData()
/*     */     {
/* 781 */       return this.pending_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCreater_id()
/*     */     {
/* 788 */       return this.creater_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getClose_sessionid()
/*     */     {
/* 795 */       return this.close_sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTry_close_times()
/*     */     {
/* 802 */       return this.try_close_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoom_state(int _v_)
/*     */     {
/* 809 */       this.room_state = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoom_id(long _v_)
/*     */     {
/* 816 */       this.room_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCreater_id(long _v_)
/*     */     {
/* 823 */       this.creater_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setClose_sessionid(long _v_)
/*     */     {
/* 830 */       this.close_sessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTry_close_times(int _v_)
/*     */     {
/* 837 */       this.try_close_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 843 */       if (!(_o1_ instanceof Data)) return false;
/* 844 */       Data _o_ = (Data)_o1_;
/* 845 */       if (this.room_state != _o_.room_state) return false;
/* 846 */       if (this.room_id != _o_.room_id) return false;
/* 847 */       if (!this.members.equals(_o_.members)) return false;
/* 848 */       if (!this.pending_list.equals(_o_.pending_list)) return false;
/* 849 */       if (this.creater_id != _o_.creater_id) return false;
/* 850 */       if (this.close_sessionid != _o_.close_sessionid) return false;
/* 851 */       if (this.try_close_times != _o_.try_close_times) return false;
/* 852 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 858 */       int _h_ = 0;
/* 859 */       _h_ += this.room_state;
/* 860 */       _h_ = (int)(_h_ + this.room_id);
/* 861 */       _h_ += this.members.hashCode();
/* 862 */       _h_ += this.pending_list.hashCode();
/* 863 */       _h_ = (int)(_h_ + this.creater_id);
/* 864 */       _h_ = (int)(_h_ + this.close_sessionid);
/* 865 */       _h_ += this.try_close_times;
/* 866 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 872 */       StringBuilder _sb_ = new StringBuilder();
/* 873 */       _sb_.append("(");
/* 874 */       _sb_.append(this.room_state);
/* 875 */       _sb_.append(",");
/* 876 */       _sb_.append(this.room_id);
/* 877 */       _sb_.append(",");
/* 878 */       _sb_.append(this.members);
/* 879 */       _sb_.append(",");
/* 880 */       _sb_.append(this.pending_list);
/* 881 */       _sb_.append(",");
/* 882 */       _sb_.append(this.creater_id);
/* 883 */       _sb_.append(",");
/* 884 */       _sb_.append(this.close_sessionid);
/* 885 */       _sb_.append(",");
/* 886 */       _sb_.append(this.try_close_times);
/* 887 */       _sb_.append(")");
/* 888 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\VoipRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */