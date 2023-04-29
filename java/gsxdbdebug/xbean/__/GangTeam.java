/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ 
/*      */ public final class GangTeam extends XBean implements xbean.GangTeam
/*      */ {
/*      */   private String name;
/*      */   private long leader;
/*      */   private HashMap<Long, xbean.GangTeamMember> members;
/*      */   private long create_millis;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.name = "";
/*   25 */     this.leader = 0L;
/*   26 */     this.members.clear();
/*   27 */     this.create_millis = 0L;
/*      */   }
/*      */   
/*      */   GangTeam(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.name = "";
/*   34 */     this.members = new HashMap();
/*      */   }
/*      */   
/*      */   public GangTeam()
/*      */   {
/*   39 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public GangTeam(GangTeam _o_)
/*      */   {
/*   44 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   GangTeam(xbean.GangTeam _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   49 */     super(_xp_, _vn_);
/*   50 */     if ((_o1_ instanceof GangTeam)) { assign((GangTeam)_o1_);
/*   51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   53 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(GangTeam _o_) {
/*   58 */     _o_._xdb_verify_unsafe_();
/*   59 */     this.name = _o_.name;
/*   60 */     this.leader = _o_.leader;
/*   61 */     this.members = new HashMap();
/*   62 */     for (Map.Entry<Long, xbean.GangTeamMember> _e_ : _o_.members.entrySet())
/*   63 */       this.members.put(_e_.getKey(), new GangTeamMember((xbean.GangTeamMember)_e_.getValue(), this, "members"));
/*   64 */     this.create_millis = _o_.create_millis;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   69 */     this.name = _o_.name;
/*   70 */     this.leader = _o_.leader;
/*   71 */     this.members = new HashMap();
/*   72 */     for (Map.Entry<Long, xbean.GangTeamMember> _e_ : _o_.members.entrySet())
/*   73 */       this.members.put(_e_.getKey(), new GangTeamMember((xbean.GangTeamMember)_e_.getValue(), this, "members"));
/*   74 */     this.create_millis = _o_.create_millis;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   80 */     _xdb_verify_unsafe_();
/*   81 */     _os_.marshal(this.name, "UTF-16LE");
/*   82 */     _os_.marshal(this.leader);
/*   83 */     _os_.compact_uint32(this.members.size());
/*   84 */     for (Map.Entry<Long, xbean.GangTeamMember> _e_ : this.members.entrySet())
/*      */     {
/*   86 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   87 */       ((xbean.GangTeamMember)_e_.getValue()).marshal(_os_);
/*      */     }
/*   89 */     _os_.marshal(this.create_millis);
/*   90 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   96 */     _xdb_verify_unsafe_();
/*   97 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*   98 */     this.leader = _os_.unmarshal_long();
/*      */     
/*  100 */     int size = _os_.uncompact_uint32();
/*  101 */     if (size >= 12)
/*      */     {
/*  103 */       this.members = new HashMap(size * 2);
/*      */     }
/*  105 */     for (; size > 0; size--)
/*      */     {
/*  107 */       long _k_ = 0L;
/*  108 */       _k_ = _os_.unmarshal_long();
/*  109 */       xbean.GangTeamMember _v_ = new GangTeamMember(0, this, "members");
/*  110 */       _v_.unmarshal(_os_);
/*  111 */       this.members.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  114 */     this.create_millis = _os_.unmarshal_long();
/*  115 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  121 */     _xdb_verify_unsafe_();
/*  122 */     int _size_ = 0;
/*      */     try
/*      */     {
/*  125 */       _size_ += CodedOutputStream.computeBytesSize(1, ppbio.ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  129 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  131 */     _size_ += CodedOutputStream.computeInt64Size(2, this.leader);
/*  132 */     for (Map.Entry<Long, xbean.GangTeamMember> _e_ : this.members.entrySet())
/*      */     {
/*  134 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  135 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*      */     }
/*  137 */     _size_ += CodedOutputStream.computeInt64Size(4, this.create_millis);
/*  138 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  147 */       _output_.writeBytes(1, ppbio.ByteString.copyFrom(this.name, "UTF-16LE"));
/*  148 */       _output_.writeInt64(2, this.leader);
/*  149 */       for (Map.Entry<Long, xbean.GangTeamMember> _e_ : this.members.entrySet())
/*      */       {
/*  151 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  152 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*      */       }
/*  154 */       _output_.writeInt64(4, this.create_millis);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  158 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  160 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  166 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  169 */       boolean done = false;
/*  170 */       while (!done)
/*      */       {
/*  172 */         int tag = _input_.readTag();
/*  173 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  177 */           done = true;
/*  178 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  182 */           this.name = _input_.readBytes().toString("UTF-16LE");
/*  183 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  187 */           this.leader = _input_.readInt64();
/*  188 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  192 */           long _k_ = 0L;
/*  193 */           _k_ = _input_.readInt64();
/*  194 */           int readTag = _input_.readTag();
/*  195 */           if (26 != readTag)
/*      */           {
/*  197 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  199 */           xbean.GangTeamMember _v_ = new GangTeamMember(0, this, "members");
/*  200 */           _input_.readMessage(_v_);
/*  201 */           this.members.put(Long.valueOf(_k_), _v_);
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  206 */           this.create_millis = _input_.readInt64();
/*  207 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  211 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  213 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  222 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  226 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  228 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GangTeam copy()
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*  235 */     return new GangTeam(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GangTeam toData()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.GangTeam toBean()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new GangTeam(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GangTeam toDataIf()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.GangTeam toBeanIf()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return this.name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getNameOctets()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return Octets.wrap(getName(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLeader()
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*  292 */     return this.leader;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.GangTeamMember> getMembers()
/*      */   {
/*  299 */     _xdb_verify_unsafe_();
/*  300 */     return xdb.Logs.logMap(new LogKey(this, "members"), this.members);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.GangTeamMember> getMembersAsData()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*      */     
/*  309 */     GangTeam _o_ = this;
/*  310 */     Map<Long, xbean.GangTeamMember> members = new HashMap();
/*  311 */     for (Map.Entry<Long, xbean.GangTeamMember> _e_ : _o_.members.entrySet())
/*  312 */       members.put(_e_.getKey(), new GangTeamMember.Data((xbean.GangTeamMember)_e_.getValue()));
/*  313 */     return members;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCreate_millis()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return this.create_millis;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName(String _v_)
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     if (null == _v_)
/*  330 */       throw new NullPointerException();
/*  331 */     xdb.Logs.logIf(new LogKey(this, "name")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  335 */         new xdb.logs.LogString(this, GangTeam.this.name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  339 */             GangTeam.this.name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  343 */     });
/*  344 */     this.name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNameOctets(Octets _v_)
/*      */   {
/*  351 */     _xdb_verify_unsafe_();
/*  352 */     setName(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLeader(long _v_)
/*      */   {
/*  359 */     _xdb_verify_unsafe_();
/*  360 */     xdb.Logs.logIf(new LogKey(this, "leader")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  364 */         new xdb.logs.LogLong(this, GangTeam.this.leader)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  368 */             GangTeam.this.leader = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  372 */     });
/*  373 */     this.leader = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCreate_millis(long _v_)
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     xdb.Logs.logIf(new LogKey(this, "create_millis")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  385 */         new xdb.logs.LogLong(this, GangTeam.this.create_millis)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  389 */             GangTeam.this.create_millis = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  393 */     });
/*  394 */     this.create_millis = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*  401 */     GangTeam _o_ = null;
/*  402 */     if ((_o1_ instanceof GangTeam)) { _o_ = (GangTeam)_o1_;
/*  403 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  404 */       return false;
/*  405 */     if (!this.name.equals(_o_.name)) return false;
/*  406 */     if (this.leader != _o_.leader) return false;
/*  407 */     if (!this.members.equals(_o_.members)) return false;
/*  408 */     if (this.create_millis != _o_.create_millis) return false;
/*  409 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*  416 */     int _h_ = 0;
/*  417 */     _h_ += this.name.hashCode();
/*  418 */     _h_ = (int)(_h_ + this.leader);
/*  419 */     _h_ += this.members.hashCode();
/*  420 */     _h_ = (int)(_h_ + this.create_millis);
/*  421 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     StringBuilder _sb_ = new StringBuilder();
/*  429 */     _sb_.append("(");
/*  430 */     _sb_.append("'").append(this.name).append("'");
/*  431 */     _sb_.append(",");
/*  432 */     _sb_.append(this.leader);
/*  433 */     _sb_.append(",");
/*  434 */     _sb_.append(this.members);
/*  435 */     _sb_.append(",");
/*  436 */     _sb_.append(this.create_millis);
/*  437 */     _sb_.append(")");
/*  438 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  444 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  445 */     lb.add(new xdb.logs.ListenableChanged().setVarName("name"));
/*  446 */     lb.add(new xdb.logs.ListenableChanged().setVarName("leader"));
/*  447 */     lb.add(new xdb.logs.ListenableMap().setVarName("members"));
/*  448 */     lb.add(new xdb.logs.ListenableChanged().setVarName("create_millis"));
/*  449 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.GangTeam {
/*      */     private Const() {}
/*      */     
/*      */     GangTeam nThis() {
/*  456 */       return GangTeam.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  462 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangTeam copy()
/*      */     {
/*  468 */       return GangTeam.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangTeam toData()
/*      */     {
/*  474 */       return GangTeam.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.GangTeam toBean()
/*      */     {
/*  479 */       return GangTeam.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangTeam toDataIf()
/*      */     {
/*  485 */       return GangTeam.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.GangTeam toBeanIf()
/*      */     {
/*  490 */       return GangTeam.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/*  497 */       GangTeam.this._xdb_verify_unsafe_();
/*  498 */       return GangTeam.this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/*  505 */       GangTeam.this._xdb_verify_unsafe_();
/*  506 */       return GangTeam.this.getNameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLeader()
/*      */     {
/*  513 */       GangTeam.this._xdb_verify_unsafe_();
/*  514 */       return GangTeam.this.leader;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GangTeamMember> getMembers()
/*      */     {
/*  521 */       GangTeam.this._xdb_verify_unsafe_();
/*  522 */       return xdb.Consts.constMap(GangTeam.this.members);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GangTeamMember> getMembersAsData()
/*      */     {
/*  529 */       GangTeam.this._xdb_verify_unsafe_();
/*      */       
/*  531 */       GangTeam _o_ = GangTeam.this;
/*  532 */       Map<Long, xbean.GangTeamMember> members = new HashMap();
/*  533 */       for (Map.Entry<Long, xbean.GangTeamMember> _e_ : _o_.members.entrySet())
/*  534 */         members.put(_e_.getKey(), new GangTeamMember.Data((xbean.GangTeamMember)_e_.getValue()));
/*  535 */       return members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreate_millis()
/*      */     {
/*  542 */       GangTeam.this._xdb_verify_unsafe_();
/*  543 */       return GangTeam.this.create_millis;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/*  550 */       GangTeam.this._xdb_verify_unsafe_();
/*  551 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/*  558 */       GangTeam.this._xdb_verify_unsafe_();
/*  559 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLeader(long _v_)
/*      */     {
/*  566 */       GangTeam.this._xdb_verify_unsafe_();
/*  567 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreate_millis(long _v_)
/*      */     {
/*  574 */       GangTeam.this._xdb_verify_unsafe_();
/*  575 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  581 */       GangTeam.this._xdb_verify_unsafe_();
/*  582 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  588 */       GangTeam.this._xdb_verify_unsafe_();
/*  589 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  595 */       return GangTeam.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  601 */       return GangTeam.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  607 */       GangTeam.this._xdb_verify_unsafe_();
/*  608 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  614 */       return GangTeam.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  620 */       return GangTeam.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  626 */       GangTeam.this._xdb_verify_unsafe_();
/*  627 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  633 */       return GangTeam.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  639 */       return GangTeam.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  645 */       return GangTeam.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  651 */       return GangTeam.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  657 */       return GangTeam.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  663 */       return GangTeam.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  669 */       return GangTeam.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.GangTeam
/*      */   {
/*      */     private String name;
/*      */     
/*      */     private long leader;
/*      */     
/*      */     private HashMap<Long, xbean.GangTeamMember> members;
/*      */     
/*      */     private long create_millis;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  687 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  692 */       this.name = "";
/*  693 */       this.members = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.GangTeam _o1_)
/*      */     {
/*  698 */       if ((_o1_ instanceof GangTeam)) { assign((GangTeam)_o1_);
/*  699 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  700 */       } else if ((_o1_ instanceof GangTeam.Const)) assign(((GangTeam.Const)_o1_).nThis()); else {
/*  701 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(GangTeam _o_) {
/*  706 */       this.name = _o_.name;
/*  707 */       this.leader = _o_.leader;
/*  708 */       this.members = new HashMap();
/*  709 */       for (Map.Entry<Long, xbean.GangTeamMember> _e_ : _o_.members.entrySet())
/*  710 */         this.members.put(_e_.getKey(), new GangTeamMember.Data((xbean.GangTeamMember)_e_.getValue()));
/*  711 */       this.create_millis = _o_.create_millis;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  716 */       this.name = _o_.name;
/*  717 */       this.leader = _o_.leader;
/*  718 */       this.members = new HashMap();
/*  719 */       for (Map.Entry<Long, xbean.GangTeamMember> _e_ : _o_.members.entrySet())
/*  720 */         this.members.put(_e_.getKey(), new GangTeamMember.Data((xbean.GangTeamMember)_e_.getValue()));
/*  721 */       this.create_millis = _o_.create_millis;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  727 */       _os_.marshal(this.name, "UTF-16LE");
/*  728 */       _os_.marshal(this.leader);
/*  729 */       _os_.compact_uint32(this.members.size());
/*  730 */       for (Map.Entry<Long, xbean.GangTeamMember> _e_ : this.members.entrySet())
/*      */       {
/*  732 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  733 */         ((xbean.GangTeamMember)_e_.getValue()).marshal(_os_);
/*      */       }
/*  735 */       _os_.marshal(this.create_millis);
/*  736 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  742 */       this.name = _os_.unmarshal_String("UTF-16LE");
/*  743 */       this.leader = _os_.unmarshal_long();
/*      */       
/*  745 */       int size = _os_.uncompact_uint32();
/*  746 */       if (size >= 12)
/*      */       {
/*  748 */         this.members = new HashMap(size * 2);
/*      */       }
/*  750 */       for (; size > 0; size--)
/*      */       {
/*  752 */         long _k_ = 0L;
/*  753 */         _k_ = _os_.unmarshal_long();
/*  754 */         xbean.GangTeamMember _v_ = xbean.Pod.newGangTeamMemberData();
/*  755 */         _v_.unmarshal(_os_);
/*  756 */         this.members.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  759 */       this.create_millis = _os_.unmarshal_long();
/*  760 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  766 */       int _size_ = 0;
/*      */       try
/*      */       {
/*  769 */         _size_ += CodedOutputStream.computeBytesSize(1, ppbio.ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  773 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  775 */       _size_ += CodedOutputStream.computeInt64Size(2, this.leader);
/*  776 */       for (Map.Entry<Long, xbean.GangTeamMember> _e_ : this.members.entrySet())
/*      */       {
/*  778 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  779 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*      */       }
/*  781 */       _size_ += CodedOutputStream.computeInt64Size(4, this.create_millis);
/*  782 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  790 */         _output_.writeBytes(1, ppbio.ByteString.copyFrom(this.name, "UTF-16LE"));
/*  791 */         _output_.writeInt64(2, this.leader);
/*  792 */         for (Map.Entry<Long, xbean.GangTeamMember> _e_ : this.members.entrySet())
/*      */         {
/*  794 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  795 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*      */         }
/*  797 */         _output_.writeInt64(4, this.create_millis);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  801 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  803 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  811 */         boolean done = false;
/*  812 */         while (!done)
/*      */         {
/*  814 */           int tag = _input_.readTag();
/*  815 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  819 */             done = true;
/*  820 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/*  824 */             this.name = _input_.readBytes().toString("UTF-16LE");
/*  825 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  829 */             this.leader = _input_.readInt64();
/*  830 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  834 */             long _k_ = 0L;
/*  835 */             _k_ = _input_.readInt64();
/*  836 */             int readTag = _input_.readTag();
/*  837 */             if (26 != readTag)
/*      */             {
/*  839 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  841 */             xbean.GangTeamMember _v_ = xbean.Pod.newGangTeamMemberData();
/*  842 */             _input_.readMessage(_v_);
/*  843 */             this.members.put(Long.valueOf(_k_), _v_);
/*  844 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  848 */             this.create_millis = _input_.readInt64();
/*  849 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  853 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  855 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  864 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  868 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  870 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangTeam copy()
/*      */     {
/*  876 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangTeam toData()
/*      */     {
/*  882 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.GangTeam toBean()
/*      */     {
/*  887 */       return new GangTeam(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangTeam toDataIf()
/*      */     {
/*  893 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.GangTeam toBeanIf()
/*      */     {
/*  898 */       return new GangTeam(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  904 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  908 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  912 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  916 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  920 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  924 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  928 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/*  935 */       return this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/*  942 */       return Octets.wrap(getName(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLeader()
/*      */     {
/*  949 */       return this.leader;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GangTeamMember> getMembers()
/*      */     {
/*  956 */       return this.members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GangTeamMember> getMembersAsData()
/*      */     {
/*  963 */       return this.members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreate_millis()
/*      */     {
/*  970 */       return this.create_millis;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/*  977 */       if (null == _v_)
/*  978 */         throw new NullPointerException();
/*  979 */       this.name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/*  986 */       setName(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLeader(long _v_)
/*      */     {
/*  993 */       this.leader = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreate_millis(long _v_)
/*      */     {
/* 1000 */       this.create_millis = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1006 */       if (!(_o1_ instanceof Data)) return false;
/* 1007 */       Data _o_ = (Data)_o1_;
/* 1008 */       if (!this.name.equals(_o_.name)) return false;
/* 1009 */       if (this.leader != _o_.leader) return false;
/* 1010 */       if (!this.members.equals(_o_.members)) return false;
/* 1011 */       if (this.create_millis != _o_.create_millis) return false;
/* 1012 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1018 */       int _h_ = 0;
/* 1019 */       _h_ += this.name.hashCode();
/* 1020 */       _h_ = (int)(_h_ + this.leader);
/* 1021 */       _h_ += this.members.hashCode();
/* 1022 */       _h_ = (int)(_h_ + this.create_millis);
/* 1023 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1029 */       StringBuilder _sb_ = new StringBuilder();
/* 1030 */       _sb_.append("(");
/* 1031 */       _sb_.append("'").append(this.name).append("'");
/* 1032 */       _sb_.append(",");
/* 1033 */       _sb_.append(this.leader);
/* 1034 */       _sb_.append(",");
/* 1035 */       _sb_.append(this.members);
/* 1036 */       _sb_.append(",");
/* 1037 */       _sb_.append(this.create_millis);
/* 1038 */       _sb_.append(")");
/* 1039 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GangTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */