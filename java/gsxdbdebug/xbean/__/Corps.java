/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class Corps extends XBean implements xbean.Corps
/*      */ {
/*      */   private long corpsid;
/*      */   private String corpsname;
/*      */   private String corpsdeclaration;
/*      */   private int corpsbadge;
/*      */   private long createtime;
/*      */   private HashMap<Integer, xbean.CorpsDutyMembers> duty2members;
/*      */   private LinkedList<xbean.CorpsHistory> historylist;
/*      */   private int nexthistoryid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.corpsid = 0L;
/*   33 */     this.corpsname = "";
/*   34 */     this.corpsdeclaration = "";
/*   35 */     this.corpsbadge = 0;
/*   36 */     this.createtime = 0L;
/*   37 */     this.duty2members.clear();
/*   38 */     this.historylist.clear();
/*   39 */     this.nexthistoryid = 0;
/*      */   }
/*      */   
/*      */   Corps(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.corpsname = "";
/*   46 */     this.corpsdeclaration = "";
/*   47 */     this.duty2members = new HashMap();
/*   48 */     this.historylist = new LinkedList();
/*      */   }
/*      */   
/*      */   public Corps()
/*      */   {
/*   53 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Corps(Corps _o_)
/*      */   {
/*   58 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Corps(xbean.Corps _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   63 */     super(_xp_, _vn_);
/*   64 */     if ((_o1_ instanceof Corps)) { assign((Corps)_o1_);
/*   65 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   66 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   67 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Corps _o_) {
/*   72 */     _o_._xdb_verify_unsafe_();
/*   73 */     this.corpsid = _o_.corpsid;
/*   74 */     this.corpsname = _o_.corpsname;
/*   75 */     this.corpsdeclaration = _o_.corpsdeclaration;
/*   76 */     this.corpsbadge = _o_.corpsbadge;
/*   77 */     this.createtime = _o_.createtime;
/*   78 */     this.duty2members = new HashMap();
/*   79 */     for (Map.Entry<Integer, xbean.CorpsDutyMembers> _e_ : _o_.duty2members.entrySet())
/*   80 */       this.duty2members.put(_e_.getKey(), new CorpsDutyMembers((xbean.CorpsDutyMembers)_e_.getValue(), this, "duty2members"));
/*   81 */     this.historylist = new LinkedList();
/*   82 */     for (xbean.CorpsHistory _v_ : _o_.historylist)
/*   83 */       this.historylist.add(new CorpsHistory(_v_, this, "historylist"));
/*   84 */     this.nexthistoryid = _o_.nexthistoryid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   89 */     this.corpsid = _o_.corpsid;
/*   90 */     this.corpsname = _o_.corpsname;
/*   91 */     this.corpsdeclaration = _o_.corpsdeclaration;
/*   92 */     this.corpsbadge = _o_.corpsbadge;
/*   93 */     this.createtime = _o_.createtime;
/*   94 */     this.duty2members = new HashMap();
/*   95 */     for (Map.Entry<Integer, xbean.CorpsDutyMembers> _e_ : _o_.duty2members.entrySet())
/*   96 */       this.duty2members.put(_e_.getKey(), new CorpsDutyMembers((xbean.CorpsDutyMembers)_e_.getValue(), this, "duty2members"));
/*   97 */     this.historylist = new LinkedList();
/*   98 */     for (xbean.CorpsHistory _v_ : _o_.historylist)
/*   99 */       this.historylist.add(new CorpsHistory(_v_, this, "historylist"));
/*  100 */     this.nexthistoryid = _o_.nexthistoryid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  106 */     _xdb_verify_unsafe_();
/*  107 */     _os_.marshal(this.corpsid);
/*  108 */     _os_.marshal(this.corpsname, "UTF-16LE");
/*  109 */     _os_.marshal(this.corpsdeclaration, "UTF-16LE");
/*  110 */     _os_.marshal(this.corpsbadge);
/*  111 */     _os_.marshal(this.createtime);
/*  112 */     _os_.compact_uint32(this.duty2members.size());
/*  113 */     for (Map.Entry<Integer, xbean.CorpsDutyMembers> _e_ : this.duty2members.entrySet())
/*      */     {
/*  115 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  116 */       ((xbean.CorpsDutyMembers)_e_.getValue()).marshal(_os_);
/*      */     }
/*  118 */     _os_.compact_uint32(this.historylist.size());
/*  119 */     for (xbean.CorpsHistory _v_ : this.historylist)
/*      */     {
/*  121 */       _v_.marshal(_os_);
/*      */     }
/*  123 */     _os_.marshal(this.nexthistoryid);
/*  124 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  130 */     _xdb_verify_unsafe_();
/*  131 */     this.corpsid = _os_.unmarshal_long();
/*  132 */     this.corpsname = _os_.unmarshal_String("UTF-16LE");
/*  133 */     this.corpsdeclaration = _os_.unmarshal_String("UTF-16LE");
/*  134 */     this.corpsbadge = _os_.unmarshal_int();
/*  135 */     this.createtime = _os_.unmarshal_long();
/*      */     
/*  137 */     int size = _os_.uncompact_uint32();
/*  138 */     if (size >= 12)
/*      */     {
/*  140 */       this.duty2members = new HashMap(size * 2);
/*      */     }
/*  142 */     for (; size > 0; size--)
/*      */     {
/*  144 */       int _k_ = 0;
/*  145 */       _k_ = _os_.unmarshal_int();
/*  146 */       xbean.CorpsDutyMembers _v_ = new CorpsDutyMembers(0, this, "duty2members");
/*  147 */       _v_.unmarshal(_os_);
/*  148 */       this.duty2members.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  151 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  153 */       xbean.CorpsHistory _v_ = new CorpsHistory(0, this, "historylist");
/*  154 */       _v_.unmarshal(_os_);
/*  155 */       this.historylist.add(_v_);
/*      */     }
/*  157 */     this.nexthistoryid = _os_.unmarshal_int();
/*  158 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  164 */     _xdb_verify_unsafe_();
/*  165 */     int _size_ = 0;
/*  166 */     _size_ += CodedOutputStream.computeInt64Size(1, this.corpsid);
/*      */     try
/*      */     {
/*  169 */       _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.corpsname, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  173 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  177 */       _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.corpsdeclaration, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  181 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  183 */     _size_ += CodedOutputStream.computeInt32Size(4, this.corpsbadge);
/*  184 */     _size_ += CodedOutputStream.computeInt64Size(5, this.createtime);
/*  185 */     for (Map.Entry<Integer, xbean.CorpsDutyMembers> _e_ : this.duty2members.entrySet())
/*      */     {
/*  187 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  188 */       _size_ += CodedOutputStream.computeMessageSize(6, (ppbio.Message)_e_.getValue());
/*      */     }
/*  190 */     for (xbean.CorpsHistory _v_ : this.historylist)
/*      */     {
/*  192 */       _size_ += CodedOutputStream.computeMessageSize(7, _v_);
/*      */     }
/*  194 */     _size_ += CodedOutputStream.computeInt32Size(8, this.nexthistoryid);
/*  195 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  201 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  204 */       _output_.writeInt64(1, this.corpsid);
/*  205 */       _output_.writeBytes(2, ByteString.copyFrom(this.corpsname, "UTF-16LE"));
/*  206 */       _output_.writeBytes(3, ByteString.copyFrom(this.corpsdeclaration, "UTF-16LE"));
/*  207 */       _output_.writeInt32(4, this.corpsbadge);
/*  208 */       _output_.writeInt64(5, this.createtime);
/*  209 */       for (Map.Entry<Integer, xbean.CorpsDutyMembers> _e_ : this.duty2members.entrySet())
/*      */       {
/*  211 */         _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  212 */         _output_.writeMessage(6, (ppbio.Message)_e_.getValue());
/*      */       }
/*  214 */       for (xbean.CorpsHistory _v_ : this.historylist)
/*      */       {
/*  216 */         _output_.writeMessage(7, _v_);
/*      */       }
/*  218 */       _output_.writeInt32(8, this.nexthistoryid);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  222 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  224 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  230 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  233 */       boolean done = false;
/*  234 */       while (!done)
/*      */       {
/*  236 */         int tag = _input_.readTag();
/*  237 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  241 */           done = true;
/*  242 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  246 */           this.corpsid = _input_.readInt64();
/*  247 */           break;
/*      */         
/*      */ 
/*      */         case 18: 
/*  251 */           this.corpsname = _input_.readBytes().toString("UTF-16LE");
/*  252 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  256 */           this.corpsdeclaration = _input_.readBytes().toString("UTF-16LE");
/*  257 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  261 */           this.corpsbadge = _input_.readInt32();
/*  262 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  266 */           this.createtime = _input_.readInt64();
/*  267 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  271 */           int _k_ = 0;
/*  272 */           _k_ = _input_.readInt32();
/*  273 */           int readTag = _input_.readTag();
/*  274 */           if (50 != readTag)
/*      */           {
/*  276 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  278 */           xbean.CorpsDutyMembers _v_ = new CorpsDutyMembers(0, this, "duty2members");
/*  279 */           _input_.readMessage(_v_);
/*  280 */           this.duty2members.put(Integer.valueOf(_k_), _v_);
/*  281 */           break;
/*      */         
/*      */ 
/*      */         case 58: 
/*  285 */           xbean.CorpsHistory _v_ = new CorpsHistory(0, this, "historylist");
/*  286 */           _input_.readMessage(_v_);
/*  287 */           this.historylist.add(_v_);
/*  288 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  292 */           this.nexthistoryid = _input_.readInt32();
/*  293 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  297 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  299 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  308 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  312 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  314 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Corps copy()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return new Corps(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Corps toData()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Corps toBean()
/*      */   {
/*  333 */     _xdb_verify_unsafe_();
/*  334 */     return new Corps(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Corps toDataIf()
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Corps toBeanIf()
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*  347 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*  354 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCorpsid()
/*      */   {
/*  361 */     _xdb_verify_unsafe_();
/*  362 */     return this.corpsid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getCorpsname()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return this.corpsname;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getCorpsnameOctets()
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     return Octets.wrap(getCorpsname(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getCorpsdeclaration()
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*  386 */     return this.corpsdeclaration;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getCorpsdeclarationOctets()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*  394 */     return Octets.wrap(getCorpsdeclaration(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCorpsbadge()
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     return this.corpsbadge;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCreatetime()
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     return this.createtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.CorpsDutyMembers> getDuty2members()
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     return xdb.Logs.logMap(new LogKey(this, "duty2members"), this.duty2members);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.CorpsDutyMembers> getDuty2membersAsData()
/*      */   {
/*  425 */     _xdb_verify_unsafe_();
/*      */     
/*  427 */     Corps _o_ = this;
/*  428 */     Map<Integer, xbean.CorpsDutyMembers> duty2members = new HashMap();
/*  429 */     for (Map.Entry<Integer, xbean.CorpsDutyMembers> _e_ : _o_.duty2members.entrySet())
/*  430 */       duty2members.put(_e_.getKey(), new CorpsDutyMembers.Data((xbean.CorpsDutyMembers)_e_.getValue()));
/*  431 */     return duty2members;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.CorpsHistory> getHistorylist()
/*      */   {
/*  438 */     _xdb_verify_unsafe_();
/*  439 */     return xdb.Logs.logList(new LogKey(this, "historylist"), this.historylist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.CorpsHistory> getHistorylistAsData()
/*      */   {
/*  445 */     _xdb_verify_unsafe_();
/*      */     
/*  447 */     Corps _o_ = this;
/*  448 */     List<xbean.CorpsHistory> historylist = new LinkedList();
/*  449 */     for (xbean.CorpsHistory _v_ : _o_.historylist)
/*  450 */       historylist.add(new CorpsHistory.Data(_v_));
/*  451 */     return historylist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNexthistoryid()
/*      */   {
/*  458 */     _xdb_verify_unsafe_();
/*  459 */     return this.nexthistoryid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCorpsid(long _v_)
/*      */   {
/*  466 */     _xdb_verify_unsafe_();
/*  467 */     xdb.Logs.logIf(new LogKey(this, "corpsid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  471 */         new xdb.logs.LogLong(this, Corps.this.corpsid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  475 */             Corps.this.corpsid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  479 */     });
/*  480 */     this.corpsid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCorpsname(String _v_)
/*      */   {
/*  487 */     _xdb_verify_unsafe_();
/*  488 */     if (null == _v_)
/*  489 */       throw new NullPointerException();
/*  490 */     xdb.Logs.logIf(new LogKey(this, "corpsname")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  494 */         new xdb.logs.LogString(this, Corps.this.corpsname)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  498 */             Corps.this.corpsname = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  502 */     });
/*  503 */     this.corpsname = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCorpsnameOctets(Octets _v_)
/*      */   {
/*  510 */     _xdb_verify_unsafe_();
/*  511 */     setCorpsname(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCorpsdeclaration(String _v_)
/*      */   {
/*  518 */     _xdb_verify_unsafe_();
/*  519 */     if (null == _v_)
/*  520 */       throw new NullPointerException();
/*  521 */     xdb.Logs.logIf(new LogKey(this, "corpsdeclaration")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  525 */         new xdb.logs.LogString(this, Corps.this.corpsdeclaration)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  529 */             Corps.this.corpsdeclaration = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  533 */     });
/*  534 */     this.corpsdeclaration = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCorpsdeclarationOctets(Octets _v_)
/*      */   {
/*  541 */     _xdb_verify_unsafe_();
/*  542 */     setCorpsdeclaration(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCorpsbadge(int _v_)
/*      */   {
/*  549 */     _xdb_verify_unsafe_();
/*  550 */     xdb.Logs.logIf(new LogKey(this, "corpsbadge")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  554 */         new xdb.logs.LogInt(this, Corps.this.corpsbadge)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  558 */             Corps.this.corpsbadge = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  562 */     });
/*  563 */     this.corpsbadge = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCreatetime(long _v_)
/*      */   {
/*  570 */     _xdb_verify_unsafe_();
/*  571 */     xdb.Logs.logIf(new LogKey(this, "createtime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  575 */         new xdb.logs.LogLong(this, Corps.this.createtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  579 */             Corps.this.createtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  583 */     });
/*  584 */     this.createtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNexthistoryid(int _v_)
/*      */   {
/*  591 */     _xdb_verify_unsafe_();
/*  592 */     xdb.Logs.logIf(new LogKey(this, "nexthistoryid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  596 */         new xdb.logs.LogInt(this, Corps.this.nexthistoryid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  600 */             Corps.this.nexthistoryid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  604 */     });
/*  605 */     this.nexthistoryid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  611 */     _xdb_verify_unsafe_();
/*  612 */     Corps _o_ = null;
/*  613 */     if ((_o1_ instanceof Corps)) { _o_ = (Corps)_o1_;
/*  614 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  615 */       return false;
/*  616 */     if (this.corpsid != _o_.corpsid) return false;
/*  617 */     if (!this.corpsname.equals(_o_.corpsname)) return false;
/*  618 */     if (!this.corpsdeclaration.equals(_o_.corpsdeclaration)) return false;
/*  619 */     if (this.corpsbadge != _o_.corpsbadge) return false;
/*  620 */     if (this.createtime != _o_.createtime) return false;
/*  621 */     if (!this.duty2members.equals(_o_.duty2members)) return false;
/*  622 */     if (!this.historylist.equals(_o_.historylist)) return false;
/*  623 */     if (this.nexthistoryid != _o_.nexthistoryid) return false;
/*  624 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  630 */     _xdb_verify_unsafe_();
/*  631 */     int _h_ = 0;
/*  632 */     _h_ = (int)(_h_ + this.corpsid);
/*  633 */     _h_ += this.corpsname.hashCode();
/*  634 */     _h_ += this.corpsdeclaration.hashCode();
/*  635 */     _h_ += this.corpsbadge;
/*  636 */     _h_ = (int)(_h_ + this.createtime);
/*  637 */     _h_ += this.duty2members.hashCode();
/*  638 */     _h_ += this.historylist.hashCode();
/*  639 */     _h_ += this.nexthistoryid;
/*  640 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  646 */     _xdb_verify_unsafe_();
/*  647 */     StringBuilder _sb_ = new StringBuilder();
/*  648 */     _sb_.append("(");
/*  649 */     _sb_.append(this.corpsid);
/*  650 */     _sb_.append(",");
/*  651 */     _sb_.append("'").append(this.corpsname).append("'");
/*  652 */     _sb_.append(",");
/*  653 */     _sb_.append("'").append(this.corpsdeclaration).append("'");
/*  654 */     _sb_.append(",");
/*  655 */     _sb_.append(this.corpsbadge);
/*  656 */     _sb_.append(",");
/*  657 */     _sb_.append(this.createtime);
/*  658 */     _sb_.append(",");
/*  659 */     _sb_.append(this.duty2members);
/*  660 */     _sb_.append(",");
/*  661 */     _sb_.append(this.historylist);
/*  662 */     _sb_.append(",");
/*  663 */     _sb_.append(this.nexthistoryid);
/*  664 */     _sb_.append(")");
/*  665 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  671 */     ListenableBean lb = new ListenableBean();
/*  672 */     lb.add(new ListenableChanged().setVarName("corpsid"));
/*  673 */     lb.add(new ListenableChanged().setVarName("corpsname"));
/*  674 */     lb.add(new ListenableChanged().setVarName("corpsdeclaration"));
/*  675 */     lb.add(new ListenableChanged().setVarName("corpsbadge"));
/*  676 */     lb.add(new ListenableChanged().setVarName("createtime"));
/*  677 */     lb.add(new xdb.logs.ListenableMap().setVarName("duty2members"));
/*  678 */     lb.add(new ListenableChanged().setVarName("historylist"));
/*  679 */     lb.add(new ListenableChanged().setVarName("nexthistoryid"));
/*  680 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Corps {
/*      */     private Const() {}
/*      */     
/*      */     Corps nThis() {
/*  687 */       return Corps.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  693 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Corps copy()
/*      */     {
/*  699 */       return Corps.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Corps toData()
/*      */     {
/*  705 */       return Corps.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Corps toBean()
/*      */     {
/*  710 */       return Corps.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Corps toDataIf()
/*      */     {
/*  716 */       return Corps.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Corps toBeanIf()
/*      */     {
/*  721 */       return Corps.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorpsid()
/*      */     {
/*  728 */       Corps.this._xdb_verify_unsafe_();
/*  729 */       return Corps.this.corpsid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getCorpsname()
/*      */     {
/*  736 */       Corps.this._xdb_verify_unsafe_();
/*  737 */       return Corps.this.corpsname;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getCorpsnameOctets()
/*      */     {
/*  744 */       Corps.this._xdb_verify_unsafe_();
/*  745 */       return Corps.this.getCorpsnameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getCorpsdeclaration()
/*      */     {
/*  752 */       Corps.this._xdb_verify_unsafe_();
/*  753 */       return Corps.this.corpsdeclaration;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getCorpsdeclarationOctets()
/*      */     {
/*  760 */       Corps.this._xdb_verify_unsafe_();
/*  761 */       return Corps.this.getCorpsdeclarationOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCorpsbadge()
/*      */     {
/*  768 */       Corps.this._xdb_verify_unsafe_();
/*  769 */       return Corps.this.corpsbadge;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreatetime()
/*      */     {
/*  776 */       Corps.this._xdb_verify_unsafe_();
/*  777 */       return Corps.this.createtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CorpsDutyMembers> getDuty2members()
/*      */     {
/*  784 */       Corps.this._xdb_verify_unsafe_();
/*  785 */       return xdb.Consts.constMap(Corps.this.duty2members);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CorpsDutyMembers> getDuty2membersAsData()
/*      */     {
/*  792 */       Corps.this._xdb_verify_unsafe_();
/*      */       
/*  794 */       Corps _o_ = Corps.this;
/*  795 */       Map<Integer, xbean.CorpsDutyMembers> duty2members = new HashMap();
/*  796 */       for (Map.Entry<Integer, xbean.CorpsDutyMembers> _e_ : _o_.duty2members.entrySet())
/*  797 */         duty2members.put(_e_.getKey(), new CorpsDutyMembers.Data((xbean.CorpsDutyMembers)_e_.getValue()));
/*  798 */       return duty2members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.CorpsHistory> getHistorylist()
/*      */     {
/*  805 */       Corps.this._xdb_verify_unsafe_();
/*  806 */       return xdb.Consts.constList(Corps.this.historylist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.CorpsHistory> getHistorylistAsData()
/*      */     {
/*  812 */       Corps.this._xdb_verify_unsafe_();
/*      */       
/*  814 */       Corps _o_ = Corps.this;
/*  815 */       List<xbean.CorpsHistory> historylist = new LinkedList();
/*  816 */       for (xbean.CorpsHistory _v_ : _o_.historylist)
/*  817 */         historylist.add(new CorpsHistory.Data(_v_));
/*  818 */       return historylist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNexthistoryid()
/*      */     {
/*  825 */       Corps.this._xdb_verify_unsafe_();
/*  826 */       return Corps.this.nexthistoryid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorpsid(long _v_)
/*      */     {
/*  833 */       Corps.this._xdb_verify_unsafe_();
/*  834 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorpsname(String _v_)
/*      */     {
/*  841 */       Corps.this._xdb_verify_unsafe_();
/*  842 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorpsnameOctets(Octets _v_)
/*      */     {
/*  849 */       Corps.this._xdb_verify_unsafe_();
/*  850 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorpsdeclaration(String _v_)
/*      */     {
/*  857 */       Corps.this._xdb_verify_unsafe_();
/*  858 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorpsdeclarationOctets(Octets _v_)
/*      */     {
/*  865 */       Corps.this._xdb_verify_unsafe_();
/*  866 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorpsbadge(int _v_)
/*      */     {
/*  873 */       Corps.this._xdb_verify_unsafe_();
/*  874 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreatetime(long _v_)
/*      */     {
/*  881 */       Corps.this._xdb_verify_unsafe_();
/*  882 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNexthistoryid(int _v_)
/*      */     {
/*  889 */       Corps.this._xdb_verify_unsafe_();
/*  890 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  896 */       Corps.this._xdb_verify_unsafe_();
/*  897 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  903 */       Corps.this._xdb_verify_unsafe_();
/*  904 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  910 */       return Corps.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  916 */       return Corps.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  922 */       Corps.this._xdb_verify_unsafe_();
/*  923 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  929 */       return Corps.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  935 */       return Corps.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  941 */       Corps.this._xdb_verify_unsafe_();
/*  942 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  948 */       return Corps.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  954 */       return Corps.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  960 */       return Corps.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  966 */       return Corps.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  972 */       return Corps.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  978 */       return Corps.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  984 */       return Corps.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Corps
/*      */   {
/*      */     private long corpsid;
/*      */     
/*      */     private String corpsname;
/*      */     
/*      */     private String corpsdeclaration;
/*      */     
/*      */     private int corpsbadge;
/*      */     
/*      */     private long createtime;
/*      */     
/*      */     private HashMap<Integer, xbean.CorpsDutyMembers> duty2members;
/*      */     
/*      */     private LinkedList<xbean.CorpsHistory> historylist;
/*      */     
/*      */     private int nexthistoryid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1010 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1015 */       this.corpsname = "";
/* 1016 */       this.corpsdeclaration = "";
/* 1017 */       this.duty2members = new HashMap();
/* 1018 */       this.historylist = new LinkedList();
/*      */     }
/*      */     
/*      */     Data(xbean.Corps _o1_)
/*      */     {
/* 1023 */       if ((_o1_ instanceof Corps)) { assign((Corps)_o1_);
/* 1024 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1025 */       } else if ((_o1_ instanceof Corps.Const)) assign(((Corps.Const)_o1_).nThis()); else {
/* 1026 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Corps _o_) {
/* 1031 */       this.corpsid = _o_.corpsid;
/* 1032 */       this.corpsname = _o_.corpsname;
/* 1033 */       this.corpsdeclaration = _o_.corpsdeclaration;
/* 1034 */       this.corpsbadge = _o_.corpsbadge;
/* 1035 */       this.createtime = _o_.createtime;
/* 1036 */       this.duty2members = new HashMap();
/* 1037 */       for (Map.Entry<Integer, xbean.CorpsDutyMembers> _e_ : _o_.duty2members.entrySet())
/* 1038 */         this.duty2members.put(_e_.getKey(), new CorpsDutyMembers.Data((xbean.CorpsDutyMembers)_e_.getValue()));
/* 1039 */       this.historylist = new LinkedList();
/* 1040 */       for (xbean.CorpsHistory _v_ : _o_.historylist)
/* 1041 */         this.historylist.add(new CorpsHistory.Data(_v_));
/* 1042 */       this.nexthistoryid = _o_.nexthistoryid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1047 */       this.corpsid = _o_.corpsid;
/* 1048 */       this.corpsname = _o_.corpsname;
/* 1049 */       this.corpsdeclaration = _o_.corpsdeclaration;
/* 1050 */       this.corpsbadge = _o_.corpsbadge;
/* 1051 */       this.createtime = _o_.createtime;
/* 1052 */       this.duty2members = new HashMap();
/* 1053 */       for (Map.Entry<Integer, xbean.CorpsDutyMembers> _e_ : _o_.duty2members.entrySet())
/* 1054 */         this.duty2members.put(_e_.getKey(), new CorpsDutyMembers.Data((xbean.CorpsDutyMembers)_e_.getValue()));
/* 1055 */       this.historylist = new LinkedList();
/* 1056 */       for (xbean.CorpsHistory _v_ : _o_.historylist)
/* 1057 */         this.historylist.add(new CorpsHistory.Data(_v_));
/* 1058 */       this.nexthistoryid = _o_.nexthistoryid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1064 */       _os_.marshal(this.corpsid);
/* 1065 */       _os_.marshal(this.corpsname, "UTF-16LE");
/* 1066 */       _os_.marshal(this.corpsdeclaration, "UTF-16LE");
/* 1067 */       _os_.marshal(this.corpsbadge);
/* 1068 */       _os_.marshal(this.createtime);
/* 1069 */       _os_.compact_uint32(this.duty2members.size());
/* 1070 */       for (Map.Entry<Integer, xbean.CorpsDutyMembers> _e_ : this.duty2members.entrySet())
/*      */       {
/* 1072 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1073 */         ((xbean.CorpsDutyMembers)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1075 */       _os_.compact_uint32(this.historylist.size());
/* 1076 */       for (xbean.CorpsHistory _v_ : this.historylist)
/*      */       {
/* 1078 */         _v_.marshal(_os_);
/*      */       }
/* 1080 */       _os_.marshal(this.nexthistoryid);
/* 1081 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1087 */       this.corpsid = _os_.unmarshal_long();
/* 1088 */       this.corpsname = _os_.unmarshal_String("UTF-16LE");
/* 1089 */       this.corpsdeclaration = _os_.unmarshal_String("UTF-16LE");
/* 1090 */       this.corpsbadge = _os_.unmarshal_int();
/* 1091 */       this.createtime = _os_.unmarshal_long();
/*      */       
/* 1093 */       int size = _os_.uncompact_uint32();
/* 1094 */       if (size >= 12)
/*      */       {
/* 1096 */         this.duty2members = new HashMap(size * 2);
/*      */       }
/* 1098 */       for (; size > 0; size--)
/*      */       {
/* 1100 */         int _k_ = 0;
/* 1101 */         _k_ = _os_.unmarshal_int();
/* 1102 */         xbean.CorpsDutyMembers _v_ = xbean.Pod.newCorpsDutyMembersData();
/* 1103 */         _v_.unmarshal(_os_);
/* 1104 */         this.duty2members.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1107 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1109 */         xbean.CorpsHistory _v_ = xbean.Pod.newCorpsHistoryData();
/* 1110 */         _v_.unmarshal(_os_);
/* 1111 */         this.historylist.add(_v_);
/*      */       }
/* 1113 */       this.nexthistoryid = _os_.unmarshal_int();
/* 1114 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1120 */       int _size_ = 0;
/* 1121 */       _size_ += CodedOutputStream.computeInt64Size(1, this.corpsid);
/*      */       try
/*      */       {
/* 1124 */         _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.corpsname, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/* 1128 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/* 1132 */         _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.corpsdeclaration, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/* 1136 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1138 */       _size_ += CodedOutputStream.computeInt32Size(4, this.corpsbadge);
/* 1139 */       _size_ += CodedOutputStream.computeInt64Size(5, this.createtime);
/* 1140 */       for (Map.Entry<Integer, xbean.CorpsDutyMembers> _e_ : this.duty2members.entrySet())
/*      */       {
/* 1142 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/* 1143 */         _size_ += CodedOutputStream.computeMessageSize(6, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1145 */       for (xbean.CorpsHistory _v_ : this.historylist)
/*      */       {
/* 1147 */         _size_ += CodedOutputStream.computeMessageSize(7, _v_);
/*      */       }
/* 1149 */       _size_ += CodedOutputStream.computeInt32Size(8, this.nexthistoryid);
/* 1150 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1158 */         _output_.writeInt64(1, this.corpsid);
/* 1159 */         _output_.writeBytes(2, ByteString.copyFrom(this.corpsname, "UTF-16LE"));
/* 1160 */         _output_.writeBytes(3, ByteString.copyFrom(this.corpsdeclaration, "UTF-16LE"));
/* 1161 */         _output_.writeInt32(4, this.corpsbadge);
/* 1162 */         _output_.writeInt64(5, this.createtime);
/* 1163 */         for (Map.Entry<Integer, xbean.CorpsDutyMembers> _e_ : this.duty2members.entrySet())
/*      */         {
/* 1165 */           _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/* 1166 */           _output_.writeMessage(6, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1168 */         for (xbean.CorpsHistory _v_ : this.historylist)
/*      */         {
/* 1170 */           _output_.writeMessage(7, _v_);
/*      */         }
/* 1172 */         _output_.writeInt32(8, this.nexthistoryid);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1176 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1178 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1186 */         boolean done = false;
/* 1187 */         while (!done)
/*      */         {
/* 1189 */           int tag = _input_.readTag();
/* 1190 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1194 */             done = true;
/* 1195 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1199 */             this.corpsid = _input_.readInt64();
/* 1200 */             break;
/*      */           
/*      */ 
/*      */           case 18: 
/* 1204 */             this.corpsname = _input_.readBytes().toString("UTF-16LE");
/* 1205 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/* 1209 */             this.corpsdeclaration = _input_.readBytes().toString("UTF-16LE");
/* 1210 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1214 */             this.corpsbadge = _input_.readInt32();
/* 1215 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1219 */             this.createtime = _input_.readInt64();
/* 1220 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1224 */             int _k_ = 0;
/* 1225 */             _k_ = _input_.readInt32();
/* 1226 */             int readTag = _input_.readTag();
/* 1227 */             if (50 != readTag)
/*      */             {
/* 1229 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1231 */             xbean.CorpsDutyMembers _v_ = xbean.Pod.newCorpsDutyMembersData();
/* 1232 */             _input_.readMessage(_v_);
/* 1233 */             this.duty2members.put(Integer.valueOf(_k_), _v_);
/* 1234 */             break;
/*      */           
/*      */ 
/*      */           case 58: 
/* 1238 */             xbean.CorpsHistory _v_ = xbean.Pod.newCorpsHistoryData();
/* 1239 */             _input_.readMessage(_v_);
/* 1240 */             this.historylist.add(_v_);
/* 1241 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1245 */             this.nexthistoryid = _input_.readInt32();
/* 1246 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1250 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1252 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1261 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1265 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1267 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Corps copy()
/*      */     {
/* 1273 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Corps toData()
/*      */     {
/* 1279 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Corps toBean()
/*      */     {
/* 1284 */       return new Corps(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Corps toDataIf()
/*      */     {
/* 1290 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Corps toBeanIf()
/*      */     {
/* 1295 */       return new Corps(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1301 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1305 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1309 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1313 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1317 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1321 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1325 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorpsid()
/*      */     {
/* 1332 */       return this.corpsid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getCorpsname()
/*      */     {
/* 1339 */       return this.corpsname;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getCorpsnameOctets()
/*      */     {
/* 1346 */       return Octets.wrap(getCorpsname(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getCorpsdeclaration()
/*      */     {
/* 1353 */       return this.corpsdeclaration;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getCorpsdeclarationOctets()
/*      */     {
/* 1360 */       return Octets.wrap(getCorpsdeclaration(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCorpsbadge()
/*      */     {
/* 1367 */       return this.corpsbadge;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreatetime()
/*      */     {
/* 1374 */       return this.createtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CorpsDutyMembers> getDuty2members()
/*      */     {
/* 1381 */       return this.duty2members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CorpsDutyMembers> getDuty2membersAsData()
/*      */     {
/* 1388 */       return this.duty2members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.CorpsHistory> getHistorylist()
/*      */     {
/* 1395 */       return this.historylist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.CorpsHistory> getHistorylistAsData()
/*      */     {
/* 1402 */       return this.historylist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNexthistoryid()
/*      */     {
/* 1409 */       return this.nexthistoryid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorpsid(long _v_)
/*      */     {
/* 1416 */       this.corpsid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorpsname(String _v_)
/*      */     {
/* 1423 */       if (null == _v_)
/* 1424 */         throw new NullPointerException();
/* 1425 */       this.corpsname = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorpsnameOctets(Octets _v_)
/*      */     {
/* 1432 */       setCorpsname(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorpsdeclaration(String _v_)
/*      */     {
/* 1439 */       if (null == _v_)
/* 1440 */         throw new NullPointerException();
/* 1441 */       this.corpsdeclaration = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorpsdeclarationOctets(Octets _v_)
/*      */     {
/* 1448 */       setCorpsdeclaration(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorpsbadge(int _v_)
/*      */     {
/* 1455 */       this.corpsbadge = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreatetime(long _v_)
/*      */     {
/* 1462 */       this.createtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNexthistoryid(int _v_)
/*      */     {
/* 1469 */       this.nexthistoryid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1475 */       if (!(_o1_ instanceof Data)) return false;
/* 1476 */       Data _o_ = (Data)_o1_;
/* 1477 */       if (this.corpsid != _o_.corpsid) return false;
/* 1478 */       if (!this.corpsname.equals(_o_.corpsname)) return false;
/* 1479 */       if (!this.corpsdeclaration.equals(_o_.corpsdeclaration)) return false;
/* 1480 */       if (this.corpsbadge != _o_.corpsbadge) return false;
/* 1481 */       if (this.createtime != _o_.createtime) return false;
/* 1482 */       if (!this.duty2members.equals(_o_.duty2members)) return false;
/* 1483 */       if (!this.historylist.equals(_o_.historylist)) return false;
/* 1484 */       if (this.nexthistoryid != _o_.nexthistoryid) return false;
/* 1485 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1491 */       int _h_ = 0;
/* 1492 */       _h_ = (int)(_h_ + this.corpsid);
/* 1493 */       _h_ += this.corpsname.hashCode();
/* 1494 */       _h_ += this.corpsdeclaration.hashCode();
/* 1495 */       _h_ += this.corpsbadge;
/* 1496 */       _h_ = (int)(_h_ + this.createtime);
/* 1497 */       _h_ += this.duty2members.hashCode();
/* 1498 */       _h_ += this.historylist.hashCode();
/* 1499 */       _h_ += this.nexthistoryid;
/* 1500 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1506 */       StringBuilder _sb_ = new StringBuilder();
/* 1507 */       _sb_.append("(");
/* 1508 */       _sb_.append(this.corpsid);
/* 1509 */       _sb_.append(",");
/* 1510 */       _sb_.append("'").append(this.corpsname).append("'");
/* 1511 */       _sb_.append(",");
/* 1512 */       _sb_.append("'").append(this.corpsdeclaration).append("'");
/* 1513 */       _sb_.append(",");
/* 1514 */       _sb_.append(this.corpsbadge);
/* 1515 */       _sb_.append(",");
/* 1516 */       _sb_.append(this.createtime);
/* 1517 */       _sb_.append(",");
/* 1518 */       _sb_.append(this.duty2members);
/* 1519 */       _sb_.append(",");
/* 1520 */       _sb_.append(this.historylist);
/* 1521 */       _sb_.append(",");
/* 1522 */       _sb_.append(this.nexthistoryid);
/* 1523 */       _sb_.append(")");
/* 1524 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Corps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */