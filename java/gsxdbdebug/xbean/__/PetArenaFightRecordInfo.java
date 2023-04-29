/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xbean.Pod;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class PetArenaFightRecordInfo extends XBean implements xbean.PetArenaFightRecordInfo
/*      */ {
/*      */   private long recordid;
/*      */   private int record_type;
/*      */   private int is_win;
/*      */   private int old_rank;
/*      */   private int new_rank;
/*      */   private long roleid;
/*      */   private int avatar;
/*      */   private int avatar_frame;
/*      */   private String name;
/*      */   private int occupation;
/*      */   private int gender;
/*      */   private long time;
/*      */   private ArrayList<xbean.PetArenaFightInfo> activie_pet_infos;
/*      */   private ArrayList<xbean.PetArenaFightInfo> passive_pet_infos;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   44 */     this.recordid = 0L;
/*   45 */     this.record_type = 0;
/*   46 */     this.is_win = 0;
/*   47 */     this.old_rank = 0;
/*   48 */     this.new_rank = 0;
/*   49 */     this.roleid = 0L;
/*   50 */     this.avatar = 0;
/*   51 */     this.avatar_frame = 0;
/*   52 */     this.name = "";
/*   53 */     this.occupation = 0;
/*   54 */     this.gender = 0;
/*   55 */     this.time = 0L;
/*   56 */     this.activie_pet_infos.clear();
/*   57 */     this.passive_pet_infos.clear();
/*      */   }
/*      */   
/*      */   PetArenaFightRecordInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   62 */     super(_xp_, _vn_);
/*   63 */     this.record_type = 0;
/*   64 */     this.is_win = 0;
/*   65 */     this.old_rank = 0;
/*   66 */     this.new_rank = 0;
/*   67 */     this.roleid = 0L;
/*   68 */     this.avatar = 0;
/*   69 */     this.avatar_frame = 0;
/*   70 */     this.name = "";
/*   71 */     this.occupation = 0;
/*   72 */     this.gender = 0;
/*   73 */     this.activie_pet_infos = new ArrayList();
/*   74 */     this.passive_pet_infos = new ArrayList();
/*      */   }
/*      */   
/*      */   public PetArenaFightRecordInfo()
/*      */   {
/*   79 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public PetArenaFightRecordInfo(PetArenaFightRecordInfo _o_)
/*      */   {
/*   84 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   PetArenaFightRecordInfo(xbean.PetArenaFightRecordInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   89 */     super(_xp_, _vn_);
/*   90 */     if ((_o1_ instanceof PetArenaFightRecordInfo)) { assign((PetArenaFightRecordInfo)_o1_);
/*   91 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   92 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   93 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(PetArenaFightRecordInfo _o_) {
/*   98 */     _o_._xdb_verify_unsafe_();
/*   99 */     this.recordid = _o_.recordid;
/*  100 */     this.record_type = _o_.record_type;
/*  101 */     this.is_win = _o_.is_win;
/*  102 */     this.old_rank = _o_.old_rank;
/*  103 */     this.new_rank = _o_.new_rank;
/*  104 */     this.roleid = _o_.roleid;
/*  105 */     this.avatar = _o_.avatar;
/*  106 */     this.avatar_frame = _o_.avatar_frame;
/*  107 */     this.name = _o_.name;
/*  108 */     this.occupation = _o_.occupation;
/*  109 */     this.gender = _o_.gender;
/*  110 */     this.time = _o_.time;
/*  111 */     this.activie_pet_infos = new ArrayList();
/*  112 */     for (xbean.PetArenaFightInfo _v_ : _o_.activie_pet_infos)
/*  113 */       this.activie_pet_infos.add(new PetArenaFightInfo(_v_, this, "activie_pet_infos"));
/*  114 */     this.passive_pet_infos = new ArrayList();
/*  115 */     for (xbean.PetArenaFightInfo _v_ : _o_.passive_pet_infos) {
/*  116 */       this.passive_pet_infos.add(new PetArenaFightInfo(_v_, this, "passive_pet_infos"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*  121 */     this.recordid = _o_.recordid;
/*  122 */     this.record_type = _o_.record_type;
/*  123 */     this.is_win = _o_.is_win;
/*  124 */     this.old_rank = _o_.old_rank;
/*  125 */     this.new_rank = _o_.new_rank;
/*  126 */     this.roleid = _o_.roleid;
/*  127 */     this.avatar = _o_.avatar;
/*  128 */     this.avatar_frame = _o_.avatar_frame;
/*  129 */     this.name = _o_.name;
/*  130 */     this.occupation = _o_.occupation;
/*  131 */     this.gender = _o_.gender;
/*  132 */     this.time = _o_.time;
/*  133 */     this.activie_pet_infos = new ArrayList();
/*  134 */     for (xbean.PetArenaFightInfo _v_ : _o_.activie_pet_infos)
/*  135 */       this.activie_pet_infos.add(new PetArenaFightInfo(_v_, this, "activie_pet_infos"));
/*  136 */     this.passive_pet_infos = new ArrayList();
/*  137 */     for (xbean.PetArenaFightInfo _v_ : _o_.passive_pet_infos) {
/*  138 */       this.passive_pet_infos.add(new PetArenaFightInfo(_v_, this, "passive_pet_infos"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*  145 */     _os_.marshal(this.recordid);
/*  146 */     _os_.marshal(this.record_type);
/*  147 */     _os_.marshal(this.is_win);
/*  148 */     _os_.marshal(this.old_rank);
/*  149 */     _os_.marshal(this.new_rank);
/*  150 */     _os_.marshal(this.roleid);
/*  151 */     _os_.marshal(this.avatar);
/*  152 */     _os_.marshal(this.avatar_frame);
/*  153 */     _os_.marshal(this.name, "UTF-16LE");
/*  154 */     _os_.marshal(this.occupation);
/*  155 */     _os_.marshal(this.gender);
/*  156 */     _os_.marshal(this.time);
/*  157 */     _os_.compact_uint32(this.activie_pet_infos.size());
/*  158 */     for (xbean.PetArenaFightInfo _v_ : this.activie_pet_infos)
/*      */     {
/*  160 */       _v_.marshal(_os_);
/*      */     }
/*  162 */     _os_.compact_uint32(this.passive_pet_infos.size());
/*  163 */     for (xbean.PetArenaFightInfo _v_ : this.passive_pet_infos)
/*      */     {
/*  165 */       _v_.marshal(_os_);
/*      */     }
/*  167 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  173 */     _xdb_verify_unsafe_();
/*  174 */     this.recordid = _os_.unmarshal_long();
/*  175 */     this.record_type = _os_.unmarshal_int();
/*  176 */     this.is_win = _os_.unmarshal_int();
/*  177 */     this.old_rank = _os_.unmarshal_int();
/*  178 */     this.new_rank = _os_.unmarshal_int();
/*  179 */     this.roleid = _os_.unmarshal_long();
/*  180 */     this.avatar = _os_.unmarshal_int();
/*  181 */     this.avatar_frame = _os_.unmarshal_int();
/*  182 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  183 */     this.occupation = _os_.unmarshal_int();
/*  184 */     this.gender = _os_.unmarshal_int();
/*  185 */     this.time = _os_.unmarshal_long();
/*  186 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  188 */       xbean.PetArenaFightInfo _v_ = new PetArenaFightInfo(0, this, "activie_pet_infos");
/*  189 */       _v_.unmarshal(_os_);
/*  190 */       this.activie_pet_infos.add(_v_);
/*      */     }
/*  192 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  194 */       xbean.PetArenaFightInfo _v_ = new PetArenaFightInfo(0, this, "passive_pet_infos");
/*  195 */       _v_.unmarshal(_os_);
/*  196 */       this.passive_pet_infos.add(_v_);
/*      */     }
/*  198 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  204 */     _xdb_verify_unsafe_();
/*  205 */     int _size_ = 0;
/*  206 */     _size_ += CodedOutputStream.computeInt64Size(1, this.recordid);
/*  207 */     _size_ += CodedOutputStream.computeInt32Size(2, this.record_type);
/*  208 */     _size_ += CodedOutputStream.computeInt32Size(3, this.is_win);
/*  209 */     _size_ += CodedOutputStream.computeInt32Size(4, this.old_rank);
/*  210 */     _size_ += CodedOutputStream.computeInt32Size(5, this.new_rank);
/*  211 */     _size_ += CodedOutputStream.computeInt64Size(6, this.roleid);
/*  212 */     _size_ += CodedOutputStream.computeInt32Size(7, this.avatar);
/*  213 */     _size_ += CodedOutputStream.computeInt32Size(8, this.avatar_frame);
/*      */     try
/*      */     {
/*  216 */       _size_ += CodedOutputStream.computeBytesSize(9, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  220 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  222 */     _size_ += CodedOutputStream.computeInt32Size(10, this.occupation);
/*  223 */     _size_ += CodedOutputStream.computeInt32Size(11, this.gender);
/*  224 */     _size_ += CodedOutputStream.computeInt64Size(12, this.time);
/*  225 */     for (xbean.PetArenaFightInfo _v_ : this.activie_pet_infos)
/*      */     {
/*  227 */       _size_ += CodedOutputStream.computeMessageSize(13, _v_);
/*      */     }
/*  229 */     for (xbean.PetArenaFightInfo _v_ : this.passive_pet_infos)
/*      */     {
/*  231 */       _size_ += CodedOutputStream.computeMessageSize(14, _v_);
/*      */     }
/*  233 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  239 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  242 */       _output_.writeInt64(1, this.recordid);
/*  243 */       _output_.writeInt32(2, this.record_type);
/*  244 */       _output_.writeInt32(3, this.is_win);
/*  245 */       _output_.writeInt32(4, this.old_rank);
/*  246 */       _output_.writeInt32(5, this.new_rank);
/*  247 */       _output_.writeInt64(6, this.roleid);
/*  248 */       _output_.writeInt32(7, this.avatar);
/*  249 */       _output_.writeInt32(8, this.avatar_frame);
/*  250 */       _output_.writeBytes(9, ByteString.copyFrom(this.name, "UTF-16LE"));
/*  251 */       _output_.writeInt32(10, this.occupation);
/*  252 */       _output_.writeInt32(11, this.gender);
/*  253 */       _output_.writeInt64(12, this.time);
/*  254 */       for (xbean.PetArenaFightInfo _v_ : this.activie_pet_infos)
/*      */       {
/*  256 */         _output_.writeMessage(13, _v_);
/*      */       }
/*  258 */       for (xbean.PetArenaFightInfo _v_ : this.passive_pet_infos)
/*      */       {
/*  260 */         _output_.writeMessage(14, _v_);
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  265 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  267 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  273 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  276 */       boolean done = false;
/*  277 */       while (!done)
/*      */       {
/*  279 */         int tag = _input_.readTag();
/*  280 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  284 */           done = true;
/*  285 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  289 */           this.recordid = _input_.readInt64();
/*  290 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  294 */           this.record_type = _input_.readInt32();
/*  295 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  299 */           this.is_win = _input_.readInt32();
/*  300 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  304 */           this.old_rank = _input_.readInt32();
/*  305 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  309 */           this.new_rank = _input_.readInt32();
/*  310 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  314 */           this.roleid = _input_.readInt64();
/*  315 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  319 */           this.avatar = _input_.readInt32();
/*  320 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  324 */           this.avatar_frame = _input_.readInt32();
/*  325 */           break;
/*      */         
/*      */ 
/*      */         case 74: 
/*  329 */           this.name = _input_.readBytes().toString("UTF-16LE");
/*  330 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  334 */           this.occupation = _input_.readInt32();
/*  335 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  339 */           this.gender = _input_.readInt32();
/*  340 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  344 */           this.time = _input_.readInt64();
/*  345 */           break;
/*      */         
/*      */ 
/*      */         case 106: 
/*  349 */           xbean.PetArenaFightInfo _v_ = new PetArenaFightInfo(0, this, "activie_pet_infos");
/*  350 */           _input_.readMessage(_v_);
/*  351 */           this.activie_pet_infos.add(_v_);
/*  352 */           break;
/*      */         
/*      */ 
/*      */         case 114: 
/*  356 */           xbean.PetArenaFightInfo _v_ = new PetArenaFightInfo(0, this, "passive_pet_infos");
/*  357 */           _input_.readMessage(_v_);
/*  358 */           this.passive_pet_infos.add(_v_);
/*  359 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  363 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  365 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  374 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  378 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  380 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PetArenaFightRecordInfo copy()
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     return new PetArenaFightRecordInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PetArenaFightRecordInfo toData()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*  394 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PetArenaFightRecordInfo toBean()
/*      */   {
/*  399 */     _xdb_verify_unsafe_();
/*  400 */     return new PetArenaFightRecordInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PetArenaFightRecordInfo toDataIf()
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PetArenaFightRecordInfo toBeanIf()
/*      */   {
/*  412 */     _xdb_verify_unsafe_();
/*  413 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRecordid()
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     return this.recordid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRecord_type()
/*      */   {
/*  435 */     _xdb_verify_unsafe_();
/*  436 */     return this.record_type;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getIs_win()
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*  444 */     return this.is_win;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOld_rank()
/*      */   {
/*  451 */     _xdb_verify_unsafe_();
/*  452 */     return this.old_rank;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNew_rank()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     return this.new_rank;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  467 */     _xdb_verify_unsafe_();
/*  468 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAvatar()
/*      */   {
/*  475 */     _xdb_verify_unsafe_();
/*  476 */     return this.avatar;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAvatar_frame()
/*      */   {
/*  483 */     _xdb_verify_unsafe_();
/*  484 */     return this.avatar_frame;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName()
/*      */   {
/*  491 */     _xdb_verify_unsafe_();
/*  492 */     return this.name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getNameOctets()
/*      */   {
/*  499 */     _xdb_verify_unsafe_();
/*  500 */     return Octets.wrap(getName(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOccupation()
/*      */   {
/*  507 */     _xdb_verify_unsafe_();
/*  508 */     return this.occupation;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGender()
/*      */   {
/*  515 */     _xdb_verify_unsafe_();
/*  516 */     return this.gender;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTime()
/*      */   {
/*  523 */     _xdb_verify_unsafe_();
/*  524 */     return this.time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.PetArenaFightInfo> getActivie_pet_infos()
/*      */   {
/*  531 */     _xdb_verify_unsafe_();
/*  532 */     return Logs.logList(new LogKey(this, "activie_pet_infos"), this.activie_pet_infos);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.PetArenaFightInfo> getActivie_pet_infosAsData()
/*      */   {
/*  538 */     _xdb_verify_unsafe_();
/*      */     
/*  540 */     PetArenaFightRecordInfo _o_ = this;
/*  541 */     List<xbean.PetArenaFightInfo> activie_pet_infos = new ArrayList();
/*  542 */     for (xbean.PetArenaFightInfo _v_ : _o_.activie_pet_infos)
/*  543 */       activie_pet_infos.add(new PetArenaFightInfo.Data(_v_));
/*  544 */     return activie_pet_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.PetArenaFightInfo> getPassive_pet_infos()
/*      */   {
/*  551 */     _xdb_verify_unsafe_();
/*  552 */     return Logs.logList(new LogKey(this, "passive_pet_infos"), this.passive_pet_infos);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.PetArenaFightInfo> getPassive_pet_infosAsData()
/*      */   {
/*  558 */     _xdb_verify_unsafe_();
/*      */     
/*  560 */     PetArenaFightRecordInfo _o_ = this;
/*  561 */     List<xbean.PetArenaFightInfo> passive_pet_infos = new ArrayList();
/*  562 */     for (xbean.PetArenaFightInfo _v_ : _o_.passive_pet_infos)
/*  563 */       passive_pet_infos.add(new PetArenaFightInfo.Data(_v_));
/*  564 */     return passive_pet_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRecordid(long _v_)
/*      */   {
/*  571 */     _xdb_verify_unsafe_();
/*  572 */     Logs.logIf(new LogKey(this, "recordid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  576 */         new LogLong(this, PetArenaFightRecordInfo.this.recordid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  580 */             PetArenaFightRecordInfo.this.recordid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  584 */     });
/*  585 */     this.recordid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRecord_type(int _v_)
/*      */   {
/*  592 */     _xdb_verify_unsafe_();
/*  593 */     Logs.logIf(new LogKey(this, "record_type")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  597 */         new LogInt(this, PetArenaFightRecordInfo.this.record_type)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  601 */             PetArenaFightRecordInfo.this.record_type = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  605 */     });
/*  606 */     this.record_type = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_win(int _v_)
/*      */   {
/*  613 */     _xdb_verify_unsafe_();
/*  614 */     Logs.logIf(new LogKey(this, "is_win")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  618 */         new LogInt(this, PetArenaFightRecordInfo.this.is_win)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  622 */             PetArenaFightRecordInfo.this.is_win = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  626 */     });
/*  627 */     this.is_win = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOld_rank(int _v_)
/*      */   {
/*  634 */     _xdb_verify_unsafe_();
/*  635 */     Logs.logIf(new LogKey(this, "old_rank")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  639 */         new LogInt(this, PetArenaFightRecordInfo.this.old_rank)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  643 */             PetArenaFightRecordInfo.this.old_rank = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  647 */     });
/*  648 */     this.old_rank = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNew_rank(int _v_)
/*      */   {
/*  655 */     _xdb_verify_unsafe_();
/*  656 */     Logs.logIf(new LogKey(this, "new_rank")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  660 */         new LogInt(this, PetArenaFightRecordInfo.this.new_rank)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  664 */             PetArenaFightRecordInfo.this.new_rank = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  668 */     });
/*  669 */     this.new_rank = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  676 */     _xdb_verify_unsafe_();
/*  677 */     Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  681 */         new LogLong(this, PetArenaFightRecordInfo.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  685 */             PetArenaFightRecordInfo.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  689 */     });
/*  690 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAvatar(int _v_)
/*      */   {
/*  697 */     _xdb_verify_unsafe_();
/*  698 */     Logs.logIf(new LogKey(this, "avatar")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  702 */         new LogInt(this, PetArenaFightRecordInfo.this.avatar)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  706 */             PetArenaFightRecordInfo.this.avatar = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  710 */     });
/*  711 */     this.avatar = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAvatar_frame(int _v_)
/*      */   {
/*  718 */     _xdb_verify_unsafe_();
/*  719 */     Logs.logIf(new LogKey(this, "avatar_frame")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  723 */         new LogInt(this, PetArenaFightRecordInfo.this.avatar_frame)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  727 */             PetArenaFightRecordInfo.this.avatar_frame = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  731 */     });
/*  732 */     this.avatar_frame = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName(String _v_)
/*      */   {
/*  739 */     _xdb_verify_unsafe_();
/*  740 */     if (null == _v_)
/*  741 */       throw new NullPointerException();
/*  742 */     Logs.logIf(new LogKey(this, "name")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  746 */         new xdb.logs.LogString(this, PetArenaFightRecordInfo.this.name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  750 */             PetArenaFightRecordInfo.this.name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  754 */     });
/*  755 */     this.name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNameOctets(Octets _v_)
/*      */   {
/*  762 */     _xdb_verify_unsafe_();
/*  763 */     setName(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOccupation(int _v_)
/*      */   {
/*  770 */     _xdb_verify_unsafe_();
/*  771 */     Logs.logIf(new LogKey(this, "occupation")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  775 */         new LogInt(this, PetArenaFightRecordInfo.this.occupation)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  779 */             PetArenaFightRecordInfo.this.occupation = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  783 */     });
/*  784 */     this.occupation = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGender(int _v_)
/*      */   {
/*  791 */     _xdb_verify_unsafe_();
/*  792 */     Logs.logIf(new LogKey(this, "gender")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  796 */         new LogInt(this, PetArenaFightRecordInfo.this.gender)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  800 */             PetArenaFightRecordInfo.this.gender = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  804 */     });
/*  805 */     this.gender = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTime(long _v_)
/*      */   {
/*  812 */     _xdb_verify_unsafe_();
/*  813 */     Logs.logIf(new LogKey(this, "time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  817 */         new LogLong(this, PetArenaFightRecordInfo.this.time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  821 */             PetArenaFightRecordInfo.this.time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  825 */     });
/*  826 */     this.time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  832 */     _xdb_verify_unsafe_();
/*  833 */     PetArenaFightRecordInfo _o_ = null;
/*  834 */     if ((_o1_ instanceof PetArenaFightRecordInfo)) { _o_ = (PetArenaFightRecordInfo)_o1_;
/*  835 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  836 */       return false;
/*  837 */     if (this.recordid != _o_.recordid) return false;
/*  838 */     if (this.record_type != _o_.record_type) return false;
/*  839 */     if (this.is_win != _o_.is_win) return false;
/*  840 */     if (this.old_rank != _o_.old_rank) return false;
/*  841 */     if (this.new_rank != _o_.new_rank) return false;
/*  842 */     if (this.roleid != _o_.roleid) return false;
/*  843 */     if (this.avatar != _o_.avatar) return false;
/*  844 */     if (this.avatar_frame != _o_.avatar_frame) return false;
/*  845 */     if (!this.name.equals(_o_.name)) return false;
/*  846 */     if (this.occupation != _o_.occupation) return false;
/*  847 */     if (this.gender != _o_.gender) return false;
/*  848 */     if (this.time != _o_.time) return false;
/*  849 */     if (!this.activie_pet_infos.equals(_o_.activie_pet_infos)) return false;
/*  850 */     if (!this.passive_pet_infos.equals(_o_.passive_pet_infos)) return false;
/*  851 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  857 */     _xdb_verify_unsafe_();
/*  858 */     int _h_ = 0;
/*  859 */     _h_ = (int)(_h_ + this.recordid);
/*  860 */     _h_ += this.record_type;
/*  861 */     _h_ += this.is_win;
/*  862 */     _h_ += this.old_rank;
/*  863 */     _h_ += this.new_rank;
/*  864 */     _h_ = (int)(_h_ + this.roleid);
/*  865 */     _h_ += this.avatar;
/*  866 */     _h_ += this.avatar_frame;
/*  867 */     _h_ += this.name.hashCode();
/*  868 */     _h_ += this.occupation;
/*  869 */     _h_ += this.gender;
/*  870 */     _h_ = (int)(_h_ + this.time);
/*  871 */     _h_ += this.activie_pet_infos.hashCode();
/*  872 */     _h_ += this.passive_pet_infos.hashCode();
/*  873 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  879 */     _xdb_verify_unsafe_();
/*  880 */     StringBuilder _sb_ = new StringBuilder();
/*  881 */     _sb_.append("(");
/*  882 */     _sb_.append(this.recordid);
/*  883 */     _sb_.append(",");
/*  884 */     _sb_.append(this.record_type);
/*  885 */     _sb_.append(",");
/*  886 */     _sb_.append(this.is_win);
/*  887 */     _sb_.append(",");
/*  888 */     _sb_.append(this.old_rank);
/*  889 */     _sb_.append(",");
/*  890 */     _sb_.append(this.new_rank);
/*  891 */     _sb_.append(",");
/*  892 */     _sb_.append(this.roleid);
/*  893 */     _sb_.append(",");
/*  894 */     _sb_.append(this.avatar);
/*  895 */     _sb_.append(",");
/*  896 */     _sb_.append(this.avatar_frame);
/*  897 */     _sb_.append(",");
/*  898 */     _sb_.append("'").append(this.name).append("'");
/*  899 */     _sb_.append(",");
/*  900 */     _sb_.append(this.occupation);
/*  901 */     _sb_.append(",");
/*  902 */     _sb_.append(this.gender);
/*  903 */     _sb_.append(",");
/*  904 */     _sb_.append(this.time);
/*  905 */     _sb_.append(",");
/*  906 */     _sb_.append(this.activie_pet_infos);
/*  907 */     _sb_.append(",");
/*  908 */     _sb_.append(this.passive_pet_infos);
/*  909 */     _sb_.append(")");
/*  910 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  916 */     ListenableBean lb = new ListenableBean();
/*  917 */     lb.add(new ListenableChanged().setVarName("recordid"));
/*  918 */     lb.add(new ListenableChanged().setVarName("record_type"));
/*  919 */     lb.add(new ListenableChanged().setVarName("is_win"));
/*  920 */     lb.add(new ListenableChanged().setVarName("old_rank"));
/*  921 */     lb.add(new ListenableChanged().setVarName("new_rank"));
/*  922 */     lb.add(new ListenableChanged().setVarName("roleid"));
/*  923 */     lb.add(new ListenableChanged().setVarName("avatar"));
/*  924 */     lb.add(new ListenableChanged().setVarName("avatar_frame"));
/*  925 */     lb.add(new ListenableChanged().setVarName("name"));
/*  926 */     lb.add(new ListenableChanged().setVarName("occupation"));
/*  927 */     lb.add(new ListenableChanged().setVarName("gender"));
/*  928 */     lb.add(new ListenableChanged().setVarName("time"));
/*  929 */     lb.add(new ListenableChanged().setVarName("activie_pet_infos"));
/*  930 */     lb.add(new ListenableChanged().setVarName("passive_pet_infos"));
/*  931 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.PetArenaFightRecordInfo {
/*      */     private Const() {}
/*      */     
/*      */     PetArenaFightRecordInfo nThis() {
/*  938 */       return PetArenaFightRecordInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  944 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaFightRecordInfo copy()
/*      */     {
/*  950 */       return PetArenaFightRecordInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaFightRecordInfo toData()
/*      */     {
/*  956 */       return PetArenaFightRecordInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.PetArenaFightRecordInfo toBean()
/*      */     {
/*  961 */       return PetArenaFightRecordInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaFightRecordInfo toDataIf()
/*      */     {
/*  967 */       return PetArenaFightRecordInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.PetArenaFightRecordInfo toBeanIf()
/*      */     {
/*  972 */       return PetArenaFightRecordInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRecordid()
/*      */     {
/*  979 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/*  980 */       return PetArenaFightRecordInfo.this.recordid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRecord_type()
/*      */     {
/*  987 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/*  988 */       return PetArenaFightRecordInfo.this.record_type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIs_win()
/*      */     {
/*  995 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/*  996 */       return PetArenaFightRecordInfo.this.is_win;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOld_rank()
/*      */     {
/* 1003 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1004 */       return PetArenaFightRecordInfo.this.old_rank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNew_rank()
/*      */     {
/* 1011 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1012 */       return PetArenaFightRecordInfo.this.new_rank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/* 1019 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1020 */       return PetArenaFightRecordInfo.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAvatar()
/*      */     {
/* 1027 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1028 */       return PetArenaFightRecordInfo.this.avatar;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAvatar_frame()
/*      */     {
/* 1035 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1036 */       return PetArenaFightRecordInfo.this.avatar_frame;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/* 1043 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1044 */       return PetArenaFightRecordInfo.this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/* 1051 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1052 */       return PetArenaFightRecordInfo.this.getNameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOccupation()
/*      */     {
/* 1059 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1060 */       return PetArenaFightRecordInfo.this.occupation;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGender()
/*      */     {
/* 1067 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1068 */       return PetArenaFightRecordInfo.this.gender;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTime()
/*      */     {
/* 1075 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1076 */       return PetArenaFightRecordInfo.this.time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetArenaFightInfo> getActivie_pet_infos()
/*      */     {
/* 1083 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1084 */       return xdb.Consts.constList(PetArenaFightRecordInfo.this.activie_pet_infos);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.PetArenaFightInfo> getActivie_pet_infosAsData()
/*      */     {
/* 1090 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1092 */       PetArenaFightRecordInfo _o_ = PetArenaFightRecordInfo.this;
/* 1093 */       List<xbean.PetArenaFightInfo> activie_pet_infos = new ArrayList();
/* 1094 */       for (xbean.PetArenaFightInfo _v_ : _o_.activie_pet_infos)
/* 1095 */         activie_pet_infos.add(new PetArenaFightInfo.Data(_v_));
/* 1096 */       return activie_pet_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetArenaFightInfo> getPassive_pet_infos()
/*      */     {
/* 1103 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1104 */       return xdb.Consts.constList(PetArenaFightRecordInfo.this.passive_pet_infos);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.PetArenaFightInfo> getPassive_pet_infosAsData()
/*      */     {
/* 1110 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1112 */       PetArenaFightRecordInfo _o_ = PetArenaFightRecordInfo.this;
/* 1113 */       List<xbean.PetArenaFightInfo> passive_pet_infos = new ArrayList();
/* 1114 */       for (xbean.PetArenaFightInfo _v_ : _o_.passive_pet_infos)
/* 1115 */         passive_pet_infos.add(new PetArenaFightInfo.Data(_v_));
/* 1116 */       return passive_pet_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecordid(long _v_)
/*      */     {
/* 1123 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1124 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecord_type(int _v_)
/*      */     {
/* 1131 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1132 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_win(int _v_)
/*      */     {
/* 1139 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1140 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOld_rank(int _v_)
/*      */     {
/* 1147 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1148 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNew_rank(int _v_)
/*      */     {
/* 1155 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1156 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1163 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1164 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAvatar(int _v_)
/*      */     {
/* 1171 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1172 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAvatar_frame(int _v_)
/*      */     {
/* 1179 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1180 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/* 1187 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1188 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/* 1195 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1196 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOccupation(int _v_)
/*      */     {
/* 1203 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1204 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGender(int _v_)
/*      */     {
/* 1211 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1212 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTime(long _v_)
/*      */     {
/* 1219 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1220 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1226 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1227 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1233 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1234 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1240 */       return PetArenaFightRecordInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1246 */       return PetArenaFightRecordInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1252 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1253 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1259 */       return PetArenaFightRecordInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1265 */       return PetArenaFightRecordInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1271 */       PetArenaFightRecordInfo.this._xdb_verify_unsafe_();
/* 1272 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1278 */       return PetArenaFightRecordInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1284 */       return PetArenaFightRecordInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1290 */       return PetArenaFightRecordInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1296 */       return PetArenaFightRecordInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1302 */       return PetArenaFightRecordInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1308 */       return PetArenaFightRecordInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1314 */       return PetArenaFightRecordInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.PetArenaFightRecordInfo
/*      */   {
/*      */     private long recordid;
/*      */     
/*      */     private int record_type;
/*      */     
/*      */     private int is_win;
/*      */     
/*      */     private int old_rank;
/*      */     
/*      */     private int new_rank;
/*      */     
/*      */     private long roleid;
/*      */     
/*      */     private int avatar;
/*      */     
/*      */     private int avatar_frame;
/*      */     
/*      */     private String name;
/*      */     
/*      */     private int occupation;
/*      */     
/*      */     private int gender;
/*      */     
/*      */     private long time;
/*      */     
/*      */     private ArrayList<xbean.PetArenaFightInfo> activie_pet_infos;
/*      */     
/*      */     private ArrayList<xbean.PetArenaFightInfo> passive_pet_infos;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1352 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1357 */       this.record_type = 0;
/* 1358 */       this.is_win = 0;
/* 1359 */       this.old_rank = 0;
/* 1360 */       this.new_rank = 0;
/* 1361 */       this.roleid = 0L;
/* 1362 */       this.avatar = 0;
/* 1363 */       this.avatar_frame = 0;
/* 1364 */       this.name = "";
/* 1365 */       this.occupation = 0;
/* 1366 */       this.gender = 0;
/* 1367 */       this.activie_pet_infos = new ArrayList();
/* 1368 */       this.passive_pet_infos = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.PetArenaFightRecordInfo _o1_)
/*      */     {
/* 1373 */       if ((_o1_ instanceof PetArenaFightRecordInfo)) { assign((PetArenaFightRecordInfo)_o1_);
/* 1374 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1375 */       } else if ((_o1_ instanceof PetArenaFightRecordInfo.Const)) assign(((PetArenaFightRecordInfo.Const)_o1_).nThis()); else {
/* 1376 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(PetArenaFightRecordInfo _o_) {
/* 1381 */       this.recordid = _o_.recordid;
/* 1382 */       this.record_type = _o_.record_type;
/* 1383 */       this.is_win = _o_.is_win;
/* 1384 */       this.old_rank = _o_.old_rank;
/* 1385 */       this.new_rank = _o_.new_rank;
/* 1386 */       this.roleid = _o_.roleid;
/* 1387 */       this.avatar = _o_.avatar;
/* 1388 */       this.avatar_frame = _o_.avatar_frame;
/* 1389 */       this.name = _o_.name;
/* 1390 */       this.occupation = _o_.occupation;
/* 1391 */       this.gender = _o_.gender;
/* 1392 */       this.time = _o_.time;
/* 1393 */       this.activie_pet_infos = new ArrayList();
/* 1394 */       for (xbean.PetArenaFightInfo _v_ : _o_.activie_pet_infos)
/* 1395 */         this.activie_pet_infos.add(new PetArenaFightInfo.Data(_v_));
/* 1396 */       this.passive_pet_infos = new ArrayList();
/* 1397 */       for (xbean.PetArenaFightInfo _v_ : _o_.passive_pet_infos) {
/* 1398 */         this.passive_pet_infos.add(new PetArenaFightInfo.Data(_v_));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/* 1403 */       this.recordid = _o_.recordid;
/* 1404 */       this.record_type = _o_.record_type;
/* 1405 */       this.is_win = _o_.is_win;
/* 1406 */       this.old_rank = _o_.old_rank;
/* 1407 */       this.new_rank = _o_.new_rank;
/* 1408 */       this.roleid = _o_.roleid;
/* 1409 */       this.avatar = _o_.avatar;
/* 1410 */       this.avatar_frame = _o_.avatar_frame;
/* 1411 */       this.name = _o_.name;
/* 1412 */       this.occupation = _o_.occupation;
/* 1413 */       this.gender = _o_.gender;
/* 1414 */       this.time = _o_.time;
/* 1415 */       this.activie_pet_infos = new ArrayList();
/* 1416 */       for (xbean.PetArenaFightInfo _v_ : _o_.activie_pet_infos)
/* 1417 */         this.activie_pet_infos.add(new PetArenaFightInfo.Data(_v_));
/* 1418 */       this.passive_pet_infos = new ArrayList();
/* 1419 */       for (xbean.PetArenaFightInfo _v_ : _o_.passive_pet_infos) {
/* 1420 */         this.passive_pet_infos.add(new PetArenaFightInfo.Data(_v_));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1426 */       _os_.marshal(this.recordid);
/* 1427 */       _os_.marshal(this.record_type);
/* 1428 */       _os_.marshal(this.is_win);
/* 1429 */       _os_.marshal(this.old_rank);
/* 1430 */       _os_.marshal(this.new_rank);
/* 1431 */       _os_.marshal(this.roleid);
/* 1432 */       _os_.marshal(this.avatar);
/* 1433 */       _os_.marshal(this.avatar_frame);
/* 1434 */       _os_.marshal(this.name, "UTF-16LE");
/* 1435 */       _os_.marshal(this.occupation);
/* 1436 */       _os_.marshal(this.gender);
/* 1437 */       _os_.marshal(this.time);
/* 1438 */       _os_.compact_uint32(this.activie_pet_infos.size());
/* 1439 */       for (xbean.PetArenaFightInfo _v_ : this.activie_pet_infos)
/*      */       {
/* 1441 */         _v_.marshal(_os_);
/*      */       }
/* 1443 */       _os_.compact_uint32(this.passive_pet_infos.size());
/* 1444 */       for (xbean.PetArenaFightInfo _v_ : this.passive_pet_infos)
/*      */       {
/* 1446 */         _v_.marshal(_os_);
/*      */       }
/* 1448 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1454 */       this.recordid = _os_.unmarshal_long();
/* 1455 */       this.record_type = _os_.unmarshal_int();
/* 1456 */       this.is_win = _os_.unmarshal_int();
/* 1457 */       this.old_rank = _os_.unmarshal_int();
/* 1458 */       this.new_rank = _os_.unmarshal_int();
/* 1459 */       this.roleid = _os_.unmarshal_long();
/* 1460 */       this.avatar = _os_.unmarshal_int();
/* 1461 */       this.avatar_frame = _os_.unmarshal_int();
/* 1462 */       this.name = _os_.unmarshal_String("UTF-16LE");
/* 1463 */       this.occupation = _os_.unmarshal_int();
/* 1464 */       this.gender = _os_.unmarshal_int();
/* 1465 */       this.time = _os_.unmarshal_long();
/* 1466 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1468 */         xbean.PetArenaFightInfo _v_ = Pod.newPetArenaFightInfoData();
/* 1469 */         _v_.unmarshal(_os_);
/* 1470 */         this.activie_pet_infos.add(_v_);
/*      */       }
/* 1472 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1474 */         xbean.PetArenaFightInfo _v_ = Pod.newPetArenaFightInfoData();
/* 1475 */         _v_.unmarshal(_os_);
/* 1476 */         this.passive_pet_infos.add(_v_);
/*      */       }
/* 1478 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1484 */       int _size_ = 0;
/* 1485 */       _size_ += CodedOutputStream.computeInt64Size(1, this.recordid);
/* 1486 */       _size_ += CodedOutputStream.computeInt32Size(2, this.record_type);
/* 1487 */       _size_ += CodedOutputStream.computeInt32Size(3, this.is_win);
/* 1488 */       _size_ += CodedOutputStream.computeInt32Size(4, this.old_rank);
/* 1489 */       _size_ += CodedOutputStream.computeInt32Size(5, this.new_rank);
/* 1490 */       _size_ += CodedOutputStream.computeInt64Size(6, this.roleid);
/* 1491 */       _size_ += CodedOutputStream.computeInt32Size(7, this.avatar);
/* 1492 */       _size_ += CodedOutputStream.computeInt32Size(8, this.avatar_frame);
/*      */       try
/*      */       {
/* 1495 */         _size_ += CodedOutputStream.computeBytesSize(9, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1499 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1501 */       _size_ += CodedOutputStream.computeInt32Size(10, this.occupation);
/* 1502 */       _size_ += CodedOutputStream.computeInt32Size(11, this.gender);
/* 1503 */       _size_ += CodedOutputStream.computeInt64Size(12, this.time);
/* 1504 */       for (xbean.PetArenaFightInfo _v_ : this.activie_pet_infos)
/*      */       {
/* 1506 */         _size_ += CodedOutputStream.computeMessageSize(13, _v_);
/*      */       }
/* 1508 */       for (xbean.PetArenaFightInfo _v_ : this.passive_pet_infos)
/*      */       {
/* 1510 */         _size_ += CodedOutputStream.computeMessageSize(14, _v_);
/*      */       }
/* 1512 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1520 */         _output_.writeInt64(1, this.recordid);
/* 1521 */         _output_.writeInt32(2, this.record_type);
/* 1522 */         _output_.writeInt32(3, this.is_win);
/* 1523 */         _output_.writeInt32(4, this.old_rank);
/* 1524 */         _output_.writeInt32(5, this.new_rank);
/* 1525 */         _output_.writeInt64(6, this.roleid);
/* 1526 */         _output_.writeInt32(7, this.avatar);
/* 1527 */         _output_.writeInt32(8, this.avatar_frame);
/* 1528 */         _output_.writeBytes(9, ByteString.copyFrom(this.name, "UTF-16LE"));
/* 1529 */         _output_.writeInt32(10, this.occupation);
/* 1530 */         _output_.writeInt32(11, this.gender);
/* 1531 */         _output_.writeInt64(12, this.time);
/* 1532 */         for (xbean.PetArenaFightInfo _v_ : this.activie_pet_infos)
/*      */         {
/* 1534 */           _output_.writeMessage(13, _v_);
/*      */         }
/* 1536 */         for (xbean.PetArenaFightInfo _v_ : this.passive_pet_infos)
/*      */         {
/* 1538 */           _output_.writeMessage(14, _v_);
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1543 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1545 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1553 */         boolean done = false;
/* 1554 */         while (!done)
/*      */         {
/* 1556 */           int tag = _input_.readTag();
/* 1557 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1561 */             done = true;
/* 1562 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1566 */             this.recordid = _input_.readInt64();
/* 1567 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1571 */             this.record_type = _input_.readInt32();
/* 1572 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1576 */             this.is_win = _input_.readInt32();
/* 1577 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1581 */             this.old_rank = _input_.readInt32();
/* 1582 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1586 */             this.new_rank = _input_.readInt32();
/* 1587 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1591 */             this.roleid = _input_.readInt64();
/* 1592 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1596 */             this.avatar = _input_.readInt32();
/* 1597 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1601 */             this.avatar_frame = _input_.readInt32();
/* 1602 */             break;
/*      */           
/*      */ 
/*      */           case 74: 
/* 1606 */             this.name = _input_.readBytes().toString("UTF-16LE");
/* 1607 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1611 */             this.occupation = _input_.readInt32();
/* 1612 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1616 */             this.gender = _input_.readInt32();
/* 1617 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 1621 */             this.time = _input_.readInt64();
/* 1622 */             break;
/*      */           
/*      */ 
/*      */           case 106: 
/* 1626 */             xbean.PetArenaFightInfo _v_ = Pod.newPetArenaFightInfoData();
/* 1627 */             _input_.readMessage(_v_);
/* 1628 */             this.activie_pet_infos.add(_v_);
/* 1629 */             break;
/*      */           
/*      */ 
/*      */           case 114: 
/* 1633 */             xbean.PetArenaFightInfo _v_ = Pod.newPetArenaFightInfoData();
/* 1634 */             _input_.readMessage(_v_);
/* 1635 */             this.passive_pet_infos.add(_v_);
/* 1636 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1640 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1642 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1651 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1655 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1657 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaFightRecordInfo copy()
/*      */     {
/* 1663 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaFightRecordInfo toData()
/*      */     {
/* 1669 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.PetArenaFightRecordInfo toBean()
/*      */     {
/* 1674 */       return new PetArenaFightRecordInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaFightRecordInfo toDataIf()
/*      */     {
/* 1680 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.PetArenaFightRecordInfo toBeanIf()
/*      */     {
/* 1685 */       return new PetArenaFightRecordInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1691 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1695 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1699 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1703 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1707 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1711 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1715 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRecordid()
/*      */     {
/* 1722 */       return this.recordid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRecord_type()
/*      */     {
/* 1729 */       return this.record_type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIs_win()
/*      */     {
/* 1736 */       return this.is_win;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOld_rank()
/*      */     {
/* 1743 */       return this.old_rank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNew_rank()
/*      */     {
/* 1750 */       return this.new_rank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/* 1757 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAvatar()
/*      */     {
/* 1764 */       return this.avatar;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAvatar_frame()
/*      */     {
/* 1771 */       return this.avatar_frame;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/* 1778 */       return this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/* 1785 */       return Octets.wrap(getName(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOccupation()
/*      */     {
/* 1792 */       return this.occupation;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGender()
/*      */     {
/* 1799 */       return this.gender;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTime()
/*      */     {
/* 1806 */       return this.time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetArenaFightInfo> getActivie_pet_infos()
/*      */     {
/* 1813 */       return this.activie_pet_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetArenaFightInfo> getActivie_pet_infosAsData()
/*      */     {
/* 1820 */       return this.activie_pet_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetArenaFightInfo> getPassive_pet_infos()
/*      */     {
/* 1827 */       return this.passive_pet_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetArenaFightInfo> getPassive_pet_infosAsData()
/*      */     {
/* 1834 */       return this.passive_pet_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecordid(long _v_)
/*      */     {
/* 1841 */       this.recordid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecord_type(int _v_)
/*      */     {
/* 1848 */       this.record_type = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_win(int _v_)
/*      */     {
/* 1855 */       this.is_win = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOld_rank(int _v_)
/*      */     {
/* 1862 */       this.old_rank = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNew_rank(int _v_)
/*      */     {
/* 1869 */       this.new_rank = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1876 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAvatar(int _v_)
/*      */     {
/* 1883 */       this.avatar = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAvatar_frame(int _v_)
/*      */     {
/* 1890 */       this.avatar_frame = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/* 1897 */       if (null == _v_)
/* 1898 */         throw new NullPointerException();
/* 1899 */       this.name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/* 1906 */       setName(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOccupation(int _v_)
/*      */     {
/* 1913 */       this.occupation = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGender(int _v_)
/*      */     {
/* 1920 */       this.gender = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTime(long _v_)
/*      */     {
/* 1927 */       this.time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1933 */       if (!(_o1_ instanceof Data)) return false;
/* 1934 */       Data _o_ = (Data)_o1_;
/* 1935 */       if (this.recordid != _o_.recordid) return false;
/* 1936 */       if (this.record_type != _o_.record_type) return false;
/* 1937 */       if (this.is_win != _o_.is_win) return false;
/* 1938 */       if (this.old_rank != _o_.old_rank) return false;
/* 1939 */       if (this.new_rank != _o_.new_rank) return false;
/* 1940 */       if (this.roleid != _o_.roleid) return false;
/* 1941 */       if (this.avatar != _o_.avatar) return false;
/* 1942 */       if (this.avatar_frame != _o_.avatar_frame) return false;
/* 1943 */       if (!this.name.equals(_o_.name)) return false;
/* 1944 */       if (this.occupation != _o_.occupation) return false;
/* 1945 */       if (this.gender != _o_.gender) return false;
/* 1946 */       if (this.time != _o_.time) return false;
/* 1947 */       if (!this.activie_pet_infos.equals(_o_.activie_pet_infos)) return false;
/* 1948 */       if (!this.passive_pet_infos.equals(_o_.passive_pet_infos)) return false;
/* 1949 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1955 */       int _h_ = 0;
/* 1956 */       _h_ = (int)(_h_ + this.recordid);
/* 1957 */       _h_ += this.record_type;
/* 1958 */       _h_ += this.is_win;
/* 1959 */       _h_ += this.old_rank;
/* 1960 */       _h_ += this.new_rank;
/* 1961 */       _h_ = (int)(_h_ + this.roleid);
/* 1962 */       _h_ += this.avatar;
/* 1963 */       _h_ += this.avatar_frame;
/* 1964 */       _h_ += this.name.hashCode();
/* 1965 */       _h_ += this.occupation;
/* 1966 */       _h_ += this.gender;
/* 1967 */       _h_ = (int)(_h_ + this.time);
/* 1968 */       _h_ += this.activie_pet_infos.hashCode();
/* 1969 */       _h_ += this.passive_pet_infos.hashCode();
/* 1970 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1976 */       StringBuilder _sb_ = new StringBuilder();
/* 1977 */       _sb_.append("(");
/* 1978 */       _sb_.append(this.recordid);
/* 1979 */       _sb_.append(",");
/* 1980 */       _sb_.append(this.record_type);
/* 1981 */       _sb_.append(",");
/* 1982 */       _sb_.append(this.is_win);
/* 1983 */       _sb_.append(",");
/* 1984 */       _sb_.append(this.old_rank);
/* 1985 */       _sb_.append(",");
/* 1986 */       _sb_.append(this.new_rank);
/* 1987 */       _sb_.append(",");
/* 1988 */       _sb_.append(this.roleid);
/* 1989 */       _sb_.append(",");
/* 1990 */       _sb_.append(this.avatar);
/* 1991 */       _sb_.append(",");
/* 1992 */       _sb_.append(this.avatar_frame);
/* 1993 */       _sb_.append(",");
/* 1994 */       _sb_.append("'").append(this.name).append("'");
/* 1995 */       _sb_.append(",");
/* 1996 */       _sb_.append(this.occupation);
/* 1997 */       _sb_.append(",");
/* 1998 */       _sb_.append(this.gender);
/* 1999 */       _sb_.append(",");
/* 2000 */       _sb_.append(this.time);
/* 2001 */       _sb_.append(",");
/* 2002 */       _sb_.append(this.activie_pet_infos);
/* 2003 */       _sb_.append(",");
/* 2004 */       _sb_.append(this.passive_pet_infos);
/* 2005 */       _sb_.append(")");
/* 2006 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PetArenaFightRecordInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */