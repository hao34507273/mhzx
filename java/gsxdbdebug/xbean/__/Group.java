/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
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
/*      */ public final class Group extends XBean implements xbean.Group
/*      */ {
/*      */   private int group_type;
/*      */   private long masterid;
/*      */   private long create_time;
/*      */   private String group_name;
/*      */   private String announcement;
/*      */   private HashMap<Long, xbean.GroupMember> groupmembers;
/*      */   private ArrayList<Long> memberlist;
/*      */   private long info_version;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.group_type = 0;
/*   33 */     this.masterid = 0L;
/*   34 */     this.create_time = 0L;
/*   35 */     this.group_name = "";
/*   36 */     this.announcement = "";
/*   37 */     this.groupmembers.clear();
/*   38 */     this.memberlist.clear();
/*   39 */     this.info_version = 1L;
/*      */   }
/*      */   
/*      */   Group(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.group_name = "";
/*   46 */     this.announcement = "";
/*   47 */     this.groupmembers = new HashMap();
/*   48 */     this.memberlist = new ArrayList();
/*   49 */     this.info_version = 1L;
/*      */   }
/*      */   
/*      */   public Group()
/*      */   {
/*   54 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Group(Group _o_)
/*      */   {
/*   59 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Group(xbean.Group _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   64 */     super(_xp_, _vn_);
/*   65 */     if ((_o1_ instanceof Group)) { assign((Group)_o1_);
/*   66 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   67 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   68 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Group _o_) {
/*   73 */     _o_._xdb_verify_unsafe_();
/*   74 */     this.group_type = _o_.group_type;
/*   75 */     this.masterid = _o_.masterid;
/*   76 */     this.create_time = _o_.create_time;
/*   77 */     this.group_name = _o_.group_name;
/*   78 */     this.announcement = _o_.announcement;
/*   79 */     this.groupmembers = new HashMap();
/*   80 */     for (Map.Entry<Long, xbean.GroupMember> _e_ : _o_.groupmembers.entrySet())
/*   81 */       this.groupmembers.put(_e_.getKey(), new GroupMember((xbean.GroupMember)_e_.getValue(), this, "groupmembers"));
/*   82 */     this.memberlist = new ArrayList();
/*   83 */     this.memberlist.addAll(_o_.memberlist);
/*   84 */     this.info_version = _o_.info_version;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   89 */     this.group_type = _o_.group_type;
/*   90 */     this.masterid = _o_.masterid;
/*   91 */     this.create_time = _o_.create_time;
/*   92 */     this.group_name = _o_.group_name;
/*   93 */     this.announcement = _o_.announcement;
/*   94 */     this.groupmembers = new HashMap();
/*   95 */     for (Map.Entry<Long, xbean.GroupMember> _e_ : _o_.groupmembers.entrySet())
/*   96 */       this.groupmembers.put(_e_.getKey(), new GroupMember((xbean.GroupMember)_e_.getValue(), this, "groupmembers"));
/*   97 */     this.memberlist = new ArrayList();
/*   98 */     this.memberlist.addAll(_o_.memberlist);
/*   99 */     this.info_version = _o_.info_version;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*  106 */     _os_.marshal(this.group_type);
/*  107 */     _os_.marshal(this.masterid);
/*  108 */     _os_.marshal(this.create_time);
/*  109 */     _os_.marshal(this.group_name, "UTF-16LE");
/*  110 */     _os_.marshal(this.announcement, "UTF-16LE");
/*  111 */     _os_.compact_uint32(this.groupmembers.size());
/*  112 */     for (Map.Entry<Long, xbean.GroupMember> _e_ : this.groupmembers.entrySet())
/*      */     {
/*  114 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  115 */       ((xbean.GroupMember)_e_.getValue()).marshal(_os_);
/*      */     }
/*  117 */     _os_.compact_uint32(this.memberlist.size());
/*  118 */     for (Long _v_ : this.memberlist)
/*      */     {
/*  120 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  122 */     _os_.marshal(this.info_version);
/*  123 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  129 */     _xdb_verify_unsafe_();
/*  130 */     this.group_type = _os_.unmarshal_int();
/*  131 */     this.masterid = _os_.unmarshal_long();
/*  132 */     this.create_time = _os_.unmarshal_long();
/*  133 */     this.group_name = _os_.unmarshal_String("UTF-16LE");
/*  134 */     this.announcement = _os_.unmarshal_String("UTF-16LE");
/*      */     
/*  136 */     int size = _os_.uncompact_uint32();
/*  137 */     if (size >= 12)
/*      */     {
/*  139 */       this.groupmembers = new HashMap(size * 2);
/*      */     }
/*  141 */     for (; size > 0; size--)
/*      */     {
/*  143 */       long _k_ = 0L;
/*  144 */       _k_ = _os_.unmarshal_long();
/*  145 */       xbean.GroupMember _v_ = new GroupMember(0, this, "groupmembers");
/*  146 */       _v_.unmarshal(_os_);
/*  147 */       this.groupmembers.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  150 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  152 */       long _v_ = 0L;
/*  153 */       _v_ = _os_.unmarshal_long();
/*  154 */       this.memberlist.add(Long.valueOf(_v_));
/*      */     }
/*  156 */     this.info_version = _os_.unmarshal_long();
/*  157 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  163 */     _xdb_verify_unsafe_();
/*  164 */     int _size_ = 0;
/*  165 */     _size_ += CodedOutputStream.computeInt32Size(1, this.group_type);
/*  166 */     _size_ += CodedOutputStream.computeInt64Size(2, this.masterid);
/*  167 */     _size_ += CodedOutputStream.computeInt64Size(3, this.create_time);
/*      */     try
/*      */     {
/*  170 */       _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.group_name, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  174 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  178 */       _size_ += CodedOutputStream.computeBytesSize(5, ByteString.copyFrom(this.announcement, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  182 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  184 */     for (Map.Entry<Long, xbean.GroupMember> _e_ : this.groupmembers.entrySet())
/*      */     {
/*  186 */       _size_ += CodedOutputStream.computeInt64Size(7, ((Long)_e_.getKey()).longValue());
/*  187 */       _size_ += CodedOutputStream.computeMessageSize(7, (ppbio.Message)_e_.getValue());
/*      */     }
/*  189 */     for (Long _v_ : this.memberlist)
/*      */     {
/*  191 */       _size_ += CodedOutputStream.computeInt64Size(8, _v_.longValue());
/*      */     }
/*  193 */     _size_ += CodedOutputStream.computeInt64Size(9, this.info_version);
/*  194 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  200 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  203 */       _output_.writeInt32(1, this.group_type);
/*  204 */       _output_.writeInt64(2, this.masterid);
/*  205 */       _output_.writeInt64(3, this.create_time);
/*  206 */       _output_.writeBytes(4, ByteString.copyFrom(this.group_name, "UTF-16LE"));
/*  207 */       _output_.writeBytes(5, ByteString.copyFrom(this.announcement, "UTF-16LE"));
/*  208 */       for (Map.Entry<Long, xbean.GroupMember> _e_ : this.groupmembers.entrySet())
/*      */       {
/*  210 */         _output_.writeInt64(7, ((Long)_e_.getKey()).longValue());
/*  211 */         _output_.writeMessage(7, (ppbio.Message)_e_.getValue());
/*      */       }
/*  213 */       for (Long _v_ : this.memberlist)
/*      */       {
/*  215 */         _output_.writeInt64(8, _v_.longValue());
/*      */       }
/*  217 */       _output_.writeInt64(9, this.info_version);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  221 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  223 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  229 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  232 */       boolean done = false;
/*  233 */       while (!done)
/*      */       {
/*  235 */         int tag = _input_.readTag();
/*  236 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  240 */           done = true;
/*  241 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  245 */           this.group_type = _input_.readInt32();
/*  246 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  250 */           this.masterid = _input_.readInt64();
/*  251 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  255 */           this.create_time = _input_.readInt64();
/*  256 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  260 */           this.group_name = _input_.readBytes().toString("UTF-16LE");
/*  261 */           break;
/*      */         
/*      */ 
/*      */         case 42: 
/*  265 */           this.announcement = _input_.readBytes().toString("UTF-16LE");
/*  266 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  270 */           long _k_ = 0L;
/*  271 */           _k_ = _input_.readInt64();
/*  272 */           int readTag = _input_.readTag();
/*  273 */           if (58 != readTag)
/*      */           {
/*  275 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  277 */           xbean.GroupMember _v_ = new GroupMember(0, this, "groupmembers");
/*  278 */           _input_.readMessage(_v_);
/*  279 */           this.groupmembers.put(Long.valueOf(_k_), _v_);
/*  280 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  284 */           long _v_ = 0L;
/*  285 */           _v_ = _input_.readInt64();
/*  286 */           this.memberlist.add(Long.valueOf(_v_));
/*  287 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  291 */           this.info_version = _input_.readInt64();
/*  292 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  296 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  298 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  307 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  311 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  313 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Group copy()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*  320 */     return new Group(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Group toData()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Group toBean()
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     return new Group(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Group toDataIf()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Group toBeanIf()
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*  353 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGroup_type()
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*  361 */     return this.group_type;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMasterid()
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     return this.masterid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCreate_time()
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     return this.create_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getGroup_name()
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*  385 */     return this.group_name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getGroup_nameOctets()
/*      */   {
/*  392 */     _xdb_verify_unsafe_();
/*  393 */     return Octets.wrap(getGroup_name(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getAnnouncement()
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*  401 */     return this.announcement;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getAnnouncementOctets()
/*      */   {
/*  408 */     _xdb_verify_unsafe_();
/*  409 */     return Octets.wrap(getAnnouncement(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.GroupMember> getGroupmembers()
/*      */   {
/*  416 */     _xdb_verify_unsafe_();
/*  417 */     return xdb.Logs.logMap(new LogKey(this, "groupmembers"), this.groupmembers);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.GroupMember> getGroupmembersAsData()
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*      */     
/*  426 */     Group _o_ = this;
/*  427 */     Map<Long, xbean.GroupMember> groupmembers = new HashMap();
/*  428 */     for (Map.Entry<Long, xbean.GroupMember> _e_ : _o_.groupmembers.entrySet())
/*  429 */       groupmembers.put(_e_.getKey(), new GroupMember.Data((xbean.GroupMember)_e_.getValue()));
/*  430 */     return groupmembers;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getMemberlist()
/*      */   {
/*  437 */     _xdb_verify_unsafe_();
/*  438 */     return xdb.Logs.logList(new LogKey(this, "memberlist"), this.memberlist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getMemberlistAsData()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*      */     
/*  446 */     Group _o_ = this;
/*  447 */     List<Long> memberlist = new ArrayList();
/*  448 */     memberlist.addAll(_o_.memberlist);
/*  449 */     return memberlist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInfo_version()
/*      */   {
/*  456 */     _xdb_verify_unsafe_();
/*  457 */     return this.info_version;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGroup_type(int _v_)
/*      */   {
/*  464 */     _xdb_verify_unsafe_();
/*  465 */     xdb.Logs.logIf(new LogKey(this, "group_type")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  469 */         new xdb.logs.LogInt(this, Group.this.group_type)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  473 */             Group.this.group_type = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  477 */     });
/*  478 */     this.group_type = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMasterid(long _v_)
/*      */   {
/*  485 */     _xdb_verify_unsafe_();
/*  486 */     xdb.Logs.logIf(new LogKey(this, "masterid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  490 */         new xdb.logs.LogLong(this, Group.this.masterid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  494 */             Group.this.masterid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  498 */     });
/*  499 */     this.masterid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCreate_time(long _v_)
/*      */   {
/*  506 */     _xdb_verify_unsafe_();
/*  507 */     xdb.Logs.logIf(new LogKey(this, "create_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  511 */         new xdb.logs.LogLong(this, Group.this.create_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  515 */             Group.this.create_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  519 */     });
/*  520 */     this.create_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGroup_name(String _v_)
/*      */   {
/*  527 */     _xdb_verify_unsafe_();
/*  528 */     if (null == _v_)
/*  529 */       throw new NullPointerException();
/*  530 */     xdb.Logs.logIf(new LogKey(this, "group_name")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  534 */         new xdb.logs.LogString(this, Group.this.group_name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  538 */             Group.this.group_name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  542 */     });
/*  543 */     this.group_name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGroup_nameOctets(Octets _v_)
/*      */   {
/*  550 */     _xdb_verify_unsafe_();
/*  551 */     setGroup_name(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAnnouncement(String _v_)
/*      */   {
/*  558 */     _xdb_verify_unsafe_();
/*  559 */     if (null == _v_)
/*  560 */       throw new NullPointerException();
/*  561 */     xdb.Logs.logIf(new LogKey(this, "announcement")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  565 */         new xdb.logs.LogString(this, Group.this.announcement)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  569 */             Group.this.announcement = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  573 */     });
/*  574 */     this.announcement = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAnnouncementOctets(Octets _v_)
/*      */   {
/*  581 */     _xdb_verify_unsafe_();
/*  582 */     setAnnouncement(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInfo_version(long _v_)
/*      */   {
/*  589 */     _xdb_verify_unsafe_();
/*  590 */     xdb.Logs.logIf(new LogKey(this, "info_version")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  594 */         new xdb.logs.LogLong(this, Group.this.info_version)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  598 */             Group.this.info_version = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  602 */     });
/*  603 */     this.info_version = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  609 */     _xdb_verify_unsafe_();
/*  610 */     Group _o_ = null;
/*  611 */     if ((_o1_ instanceof Group)) { _o_ = (Group)_o1_;
/*  612 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  613 */       return false;
/*  614 */     if (this.group_type != _o_.group_type) return false;
/*  615 */     if (this.masterid != _o_.masterid) return false;
/*  616 */     if (this.create_time != _o_.create_time) return false;
/*  617 */     if (!this.group_name.equals(_o_.group_name)) return false;
/*  618 */     if (!this.announcement.equals(_o_.announcement)) return false;
/*  619 */     if (!this.groupmembers.equals(_o_.groupmembers)) return false;
/*  620 */     if (!this.memberlist.equals(_o_.memberlist)) return false;
/*  621 */     if (this.info_version != _o_.info_version) return false;
/*  622 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  628 */     _xdb_verify_unsafe_();
/*  629 */     int _h_ = 0;
/*  630 */     _h_ += this.group_type;
/*  631 */     _h_ = (int)(_h_ + this.masterid);
/*  632 */     _h_ = (int)(_h_ + this.create_time);
/*  633 */     _h_ += this.group_name.hashCode();
/*  634 */     _h_ += this.announcement.hashCode();
/*  635 */     _h_ += this.groupmembers.hashCode();
/*  636 */     _h_ += this.memberlist.hashCode();
/*  637 */     _h_ = (int)(_h_ + this.info_version);
/*  638 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  644 */     _xdb_verify_unsafe_();
/*  645 */     StringBuilder _sb_ = new StringBuilder();
/*  646 */     _sb_.append("(");
/*  647 */     _sb_.append(this.group_type);
/*  648 */     _sb_.append(",");
/*  649 */     _sb_.append(this.masterid);
/*  650 */     _sb_.append(",");
/*  651 */     _sb_.append(this.create_time);
/*  652 */     _sb_.append(",");
/*  653 */     _sb_.append("'").append(this.group_name).append("'");
/*  654 */     _sb_.append(",");
/*  655 */     _sb_.append("'").append(this.announcement).append("'");
/*  656 */     _sb_.append(",");
/*  657 */     _sb_.append(this.groupmembers);
/*  658 */     _sb_.append(",");
/*  659 */     _sb_.append(this.memberlist);
/*  660 */     _sb_.append(",");
/*  661 */     _sb_.append(this.info_version);
/*  662 */     _sb_.append(")");
/*  663 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  669 */     ListenableBean lb = new ListenableBean();
/*  670 */     lb.add(new ListenableChanged().setVarName("group_type"));
/*  671 */     lb.add(new ListenableChanged().setVarName("masterid"));
/*  672 */     lb.add(new ListenableChanged().setVarName("create_time"));
/*  673 */     lb.add(new ListenableChanged().setVarName("group_name"));
/*  674 */     lb.add(new ListenableChanged().setVarName("announcement"));
/*  675 */     lb.add(new xdb.logs.ListenableMap().setVarName("groupmembers"));
/*  676 */     lb.add(new ListenableChanged().setVarName("memberlist"));
/*  677 */     lb.add(new ListenableChanged().setVarName("info_version"));
/*  678 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Group {
/*      */     private Const() {}
/*      */     
/*      */     Group nThis() {
/*  685 */       return Group.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  691 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Group copy()
/*      */     {
/*  697 */       return Group.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Group toData()
/*      */     {
/*  703 */       return Group.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Group toBean()
/*      */     {
/*  708 */       return Group.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Group toDataIf()
/*      */     {
/*  714 */       return Group.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Group toBeanIf()
/*      */     {
/*  719 */       return Group.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGroup_type()
/*      */     {
/*  726 */       Group.this._xdb_verify_unsafe_();
/*  727 */       return Group.this.group_type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMasterid()
/*      */     {
/*  734 */       Group.this._xdb_verify_unsafe_();
/*  735 */       return Group.this.masterid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreate_time()
/*      */     {
/*  742 */       Group.this._xdb_verify_unsafe_();
/*  743 */       return Group.this.create_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getGroup_name()
/*      */     {
/*  750 */       Group.this._xdb_verify_unsafe_();
/*  751 */       return Group.this.group_name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getGroup_nameOctets()
/*      */     {
/*  758 */       Group.this._xdb_verify_unsafe_();
/*  759 */       return Group.this.getGroup_nameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getAnnouncement()
/*      */     {
/*  766 */       Group.this._xdb_verify_unsafe_();
/*  767 */       return Group.this.announcement;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getAnnouncementOctets()
/*      */     {
/*  774 */       Group.this._xdb_verify_unsafe_();
/*  775 */       return Group.this.getAnnouncementOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GroupMember> getGroupmembers()
/*      */     {
/*  782 */       Group.this._xdb_verify_unsafe_();
/*  783 */       return xdb.Consts.constMap(Group.this.groupmembers);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GroupMember> getGroupmembersAsData()
/*      */     {
/*  790 */       Group.this._xdb_verify_unsafe_();
/*      */       
/*  792 */       Group _o_ = Group.this;
/*  793 */       Map<Long, xbean.GroupMember> groupmembers = new HashMap();
/*  794 */       for (Map.Entry<Long, xbean.GroupMember> _e_ : _o_.groupmembers.entrySet())
/*  795 */         groupmembers.put(_e_.getKey(), new GroupMember.Data((xbean.GroupMember)_e_.getValue()));
/*  796 */       return groupmembers;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getMemberlist()
/*      */     {
/*  803 */       Group.this._xdb_verify_unsafe_();
/*  804 */       return xdb.Consts.constList(Group.this.memberlist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getMemberlistAsData()
/*      */     {
/*  810 */       Group.this._xdb_verify_unsafe_();
/*      */       
/*  812 */       Group _o_ = Group.this;
/*  813 */       List<Long> memberlist = new ArrayList();
/*  814 */       memberlist.addAll(_o_.memberlist);
/*  815 */       return memberlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInfo_version()
/*      */     {
/*  822 */       Group.this._xdb_verify_unsafe_();
/*  823 */       return Group.this.info_version;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroup_type(int _v_)
/*      */     {
/*  830 */       Group.this._xdb_verify_unsafe_();
/*  831 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMasterid(long _v_)
/*      */     {
/*  838 */       Group.this._xdb_verify_unsafe_();
/*  839 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreate_time(long _v_)
/*      */     {
/*  846 */       Group.this._xdb_verify_unsafe_();
/*  847 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroup_name(String _v_)
/*      */     {
/*  854 */       Group.this._xdb_verify_unsafe_();
/*  855 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroup_nameOctets(Octets _v_)
/*      */     {
/*  862 */       Group.this._xdb_verify_unsafe_();
/*  863 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnnouncement(String _v_)
/*      */     {
/*  870 */       Group.this._xdb_verify_unsafe_();
/*  871 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnnouncementOctets(Octets _v_)
/*      */     {
/*  878 */       Group.this._xdb_verify_unsafe_();
/*  879 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInfo_version(long _v_)
/*      */     {
/*  886 */       Group.this._xdb_verify_unsafe_();
/*  887 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  893 */       Group.this._xdb_verify_unsafe_();
/*  894 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  900 */       Group.this._xdb_verify_unsafe_();
/*  901 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  907 */       return Group.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  913 */       return Group.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  919 */       Group.this._xdb_verify_unsafe_();
/*  920 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  926 */       return Group.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  932 */       return Group.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  938 */       Group.this._xdb_verify_unsafe_();
/*  939 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  945 */       return Group.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  951 */       return Group.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  957 */       return Group.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  963 */       return Group.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  969 */       return Group.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  975 */       return Group.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  981 */       return Group.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Group
/*      */   {
/*      */     private int group_type;
/*      */     
/*      */     private long masterid;
/*      */     
/*      */     private long create_time;
/*      */     
/*      */     private String group_name;
/*      */     
/*      */     private String announcement;
/*      */     
/*      */     private HashMap<Long, xbean.GroupMember> groupmembers;
/*      */     
/*      */     private ArrayList<Long> memberlist;
/*      */     
/*      */     private long info_version;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1007 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1012 */       this.group_name = "";
/* 1013 */       this.announcement = "";
/* 1014 */       this.groupmembers = new HashMap();
/* 1015 */       this.memberlist = new ArrayList();
/* 1016 */       this.info_version = 1L;
/*      */     }
/*      */     
/*      */     Data(xbean.Group _o1_)
/*      */     {
/* 1021 */       if ((_o1_ instanceof Group)) { assign((Group)_o1_);
/* 1022 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1023 */       } else if ((_o1_ instanceof Group.Const)) assign(((Group.Const)_o1_).nThis()); else {
/* 1024 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Group _o_) {
/* 1029 */       this.group_type = _o_.group_type;
/* 1030 */       this.masterid = _o_.masterid;
/* 1031 */       this.create_time = _o_.create_time;
/* 1032 */       this.group_name = _o_.group_name;
/* 1033 */       this.announcement = _o_.announcement;
/* 1034 */       this.groupmembers = new HashMap();
/* 1035 */       for (Map.Entry<Long, xbean.GroupMember> _e_ : _o_.groupmembers.entrySet())
/* 1036 */         this.groupmembers.put(_e_.getKey(), new GroupMember.Data((xbean.GroupMember)_e_.getValue()));
/* 1037 */       this.memberlist = new ArrayList();
/* 1038 */       this.memberlist.addAll(_o_.memberlist);
/* 1039 */       this.info_version = _o_.info_version;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1044 */       this.group_type = _o_.group_type;
/* 1045 */       this.masterid = _o_.masterid;
/* 1046 */       this.create_time = _o_.create_time;
/* 1047 */       this.group_name = _o_.group_name;
/* 1048 */       this.announcement = _o_.announcement;
/* 1049 */       this.groupmembers = new HashMap();
/* 1050 */       for (Map.Entry<Long, xbean.GroupMember> _e_ : _o_.groupmembers.entrySet())
/* 1051 */         this.groupmembers.put(_e_.getKey(), new GroupMember.Data((xbean.GroupMember)_e_.getValue()));
/* 1052 */       this.memberlist = new ArrayList();
/* 1053 */       this.memberlist.addAll(_o_.memberlist);
/* 1054 */       this.info_version = _o_.info_version;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1060 */       _os_.marshal(this.group_type);
/* 1061 */       _os_.marshal(this.masterid);
/* 1062 */       _os_.marshal(this.create_time);
/* 1063 */       _os_.marshal(this.group_name, "UTF-16LE");
/* 1064 */       _os_.marshal(this.announcement, "UTF-16LE");
/* 1065 */       _os_.compact_uint32(this.groupmembers.size());
/* 1066 */       for (Map.Entry<Long, xbean.GroupMember> _e_ : this.groupmembers.entrySet())
/*      */       {
/* 1068 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1069 */         ((xbean.GroupMember)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1071 */       _os_.compact_uint32(this.memberlist.size());
/* 1072 */       for (Long _v_ : this.memberlist)
/*      */       {
/* 1074 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1076 */       _os_.marshal(this.info_version);
/* 1077 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1083 */       this.group_type = _os_.unmarshal_int();
/* 1084 */       this.masterid = _os_.unmarshal_long();
/* 1085 */       this.create_time = _os_.unmarshal_long();
/* 1086 */       this.group_name = _os_.unmarshal_String("UTF-16LE");
/* 1087 */       this.announcement = _os_.unmarshal_String("UTF-16LE");
/*      */       
/* 1089 */       int size = _os_.uncompact_uint32();
/* 1090 */       if (size >= 12)
/*      */       {
/* 1092 */         this.groupmembers = new HashMap(size * 2);
/*      */       }
/* 1094 */       for (; size > 0; size--)
/*      */       {
/* 1096 */         long _k_ = 0L;
/* 1097 */         _k_ = _os_.unmarshal_long();
/* 1098 */         xbean.GroupMember _v_ = xbean.Pod.newGroupMemberData();
/* 1099 */         _v_.unmarshal(_os_);
/* 1100 */         this.groupmembers.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1103 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1105 */         long _v_ = 0L;
/* 1106 */         _v_ = _os_.unmarshal_long();
/* 1107 */         this.memberlist.add(Long.valueOf(_v_));
/*      */       }
/* 1109 */       this.info_version = _os_.unmarshal_long();
/* 1110 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1116 */       int _size_ = 0;
/* 1117 */       _size_ += CodedOutputStream.computeInt32Size(1, this.group_type);
/* 1118 */       _size_ += CodedOutputStream.computeInt64Size(2, this.masterid);
/* 1119 */       _size_ += CodedOutputStream.computeInt64Size(3, this.create_time);
/*      */       try
/*      */       {
/* 1122 */         _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.group_name, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/* 1126 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/* 1130 */         _size_ += CodedOutputStream.computeBytesSize(5, ByteString.copyFrom(this.announcement, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/* 1134 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1136 */       for (Map.Entry<Long, xbean.GroupMember> _e_ : this.groupmembers.entrySet())
/*      */       {
/* 1138 */         _size_ += CodedOutputStream.computeInt64Size(7, ((Long)_e_.getKey()).longValue());
/* 1139 */         _size_ += CodedOutputStream.computeMessageSize(7, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1141 */       for (Long _v_ : this.memberlist)
/*      */       {
/* 1143 */         _size_ += CodedOutputStream.computeInt64Size(8, _v_.longValue());
/*      */       }
/* 1145 */       _size_ += CodedOutputStream.computeInt64Size(9, this.info_version);
/* 1146 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1154 */         _output_.writeInt32(1, this.group_type);
/* 1155 */         _output_.writeInt64(2, this.masterid);
/* 1156 */         _output_.writeInt64(3, this.create_time);
/* 1157 */         _output_.writeBytes(4, ByteString.copyFrom(this.group_name, "UTF-16LE"));
/* 1158 */         _output_.writeBytes(5, ByteString.copyFrom(this.announcement, "UTF-16LE"));
/* 1159 */         for (Map.Entry<Long, xbean.GroupMember> _e_ : this.groupmembers.entrySet())
/*      */         {
/* 1161 */           _output_.writeInt64(7, ((Long)_e_.getKey()).longValue());
/* 1162 */           _output_.writeMessage(7, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1164 */         for (Long _v_ : this.memberlist)
/*      */         {
/* 1166 */           _output_.writeInt64(8, _v_.longValue());
/*      */         }
/* 1168 */         _output_.writeInt64(9, this.info_version);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1172 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1174 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1182 */         boolean done = false;
/* 1183 */         while (!done)
/*      */         {
/* 1185 */           int tag = _input_.readTag();
/* 1186 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1190 */             done = true;
/* 1191 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1195 */             this.group_type = _input_.readInt32();
/* 1196 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1200 */             this.masterid = _input_.readInt64();
/* 1201 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1205 */             this.create_time = _input_.readInt64();
/* 1206 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/* 1210 */             this.group_name = _input_.readBytes().toString("UTF-16LE");
/* 1211 */             break;
/*      */           
/*      */ 
/*      */           case 42: 
/* 1215 */             this.announcement = _input_.readBytes().toString("UTF-16LE");
/* 1216 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1220 */             long _k_ = 0L;
/* 1221 */             _k_ = _input_.readInt64();
/* 1222 */             int readTag = _input_.readTag();
/* 1223 */             if (58 != readTag)
/*      */             {
/* 1225 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1227 */             xbean.GroupMember _v_ = xbean.Pod.newGroupMemberData();
/* 1228 */             _input_.readMessage(_v_);
/* 1229 */             this.groupmembers.put(Long.valueOf(_k_), _v_);
/* 1230 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1234 */             long _v_ = 0L;
/* 1235 */             _v_ = _input_.readInt64();
/* 1236 */             this.memberlist.add(Long.valueOf(_v_));
/* 1237 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1241 */             this.info_version = _input_.readInt64();
/* 1242 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1246 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1248 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1257 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1261 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1263 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Group copy()
/*      */     {
/* 1269 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Group toData()
/*      */     {
/* 1275 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Group toBean()
/*      */     {
/* 1280 */       return new Group(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Group toDataIf()
/*      */     {
/* 1286 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Group toBeanIf()
/*      */     {
/* 1291 */       return new Group(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1297 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1301 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1305 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1309 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1313 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1317 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1321 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGroup_type()
/*      */     {
/* 1328 */       return this.group_type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMasterid()
/*      */     {
/* 1335 */       return this.masterid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreate_time()
/*      */     {
/* 1342 */       return this.create_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getGroup_name()
/*      */     {
/* 1349 */       return this.group_name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getGroup_nameOctets()
/*      */     {
/* 1356 */       return Octets.wrap(getGroup_name(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getAnnouncement()
/*      */     {
/* 1363 */       return this.announcement;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getAnnouncementOctets()
/*      */     {
/* 1370 */       return Octets.wrap(getAnnouncement(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GroupMember> getGroupmembers()
/*      */     {
/* 1377 */       return this.groupmembers;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GroupMember> getGroupmembersAsData()
/*      */     {
/* 1384 */       return this.groupmembers;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getMemberlist()
/*      */     {
/* 1391 */       return this.memberlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getMemberlistAsData()
/*      */     {
/* 1398 */       return this.memberlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInfo_version()
/*      */     {
/* 1405 */       return this.info_version;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroup_type(int _v_)
/*      */     {
/* 1412 */       this.group_type = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMasterid(long _v_)
/*      */     {
/* 1419 */       this.masterid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreate_time(long _v_)
/*      */     {
/* 1426 */       this.create_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroup_name(String _v_)
/*      */     {
/* 1433 */       if (null == _v_)
/* 1434 */         throw new NullPointerException();
/* 1435 */       this.group_name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroup_nameOctets(Octets _v_)
/*      */     {
/* 1442 */       setGroup_name(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnnouncement(String _v_)
/*      */     {
/* 1449 */       if (null == _v_)
/* 1450 */         throw new NullPointerException();
/* 1451 */       this.announcement = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnnouncementOctets(Octets _v_)
/*      */     {
/* 1458 */       setAnnouncement(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInfo_version(long _v_)
/*      */     {
/* 1465 */       this.info_version = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1471 */       if (!(_o1_ instanceof Data)) return false;
/* 1472 */       Data _o_ = (Data)_o1_;
/* 1473 */       if (this.group_type != _o_.group_type) return false;
/* 1474 */       if (this.masterid != _o_.masterid) return false;
/* 1475 */       if (this.create_time != _o_.create_time) return false;
/* 1476 */       if (!this.group_name.equals(_o_.group_name)) return false;
/* 1477 */       if (!this.announcement.equals(_o_.announcement)) return false;
/* 1478 */       if (!this.groupmembers.equals(_o_.groupmembers)) return false;
/* 1479 */       if (!this.memberlist.equals(_o_.memberlist)) return false;
/* 1480 */       if (this.info_version != _o_.info_version) return false;
/* 1481 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1487 */       int _h_ = 0;
/* 1488 */       _h_ += this.group_type;
/* 1489 */       _h_ = (int)(_h_ + this.masterid);
/* 1490 */       _h_ = (int)(_h_ + this.create_time);
/* 1491 */       _h_ += this.group_name.hashCode();
/* 1492 */       _h_ += this.announcement.hashCode();
/* 1493 */       _h_ += this.groupmembers.hashCode();
/* 1494 */       _h_ += this.memberlist.hashCode();
/* 1495 */       _h_ = (int)(_h_ + this.info_version);
/* 1496 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1502 */       StringBuilder _sb_ = new StringBuilder();
/* 1503 */       _sb_.append("(");
/* 1504 */       _sb_.append(this.group_type);
/* 1505 */       _sb_.append(",");
/* 1506 */       _sb_.append(this.masterid);
/* 1507 */       _sb_.append(",");
/* 1508 */       _sb_.append(this.create_time);
/* 1509 */       _sb_.append(",");
/* 1510 */       _sb_.append("'").append(this.group_name).append("'");
/* 1511 */       _sb_.append(",");
/* 1512 */       _sb_.append("'").append(this.announcement).append("'");
/* 1513 */       _sb_.append(",");
/* 1514 */       _sb_.append(this.groupmembers);
/* 1515 */       _sb_.append(",");
/* 1516 */       _sb_.append(this.memberlist);
/* 1517 */       _sb_.append(",");
/* 1518 */       _sb_.append(this.info_version);
/* 1519 */       _sb_.append(")");
/* 1520 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Group.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */